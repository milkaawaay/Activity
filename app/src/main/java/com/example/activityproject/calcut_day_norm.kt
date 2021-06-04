package com.example.activityproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class calcut_day_norm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcut_day_norm)
    }
    //Запись рассчитанного количества коллорий в файл
    fun saveData( key : String, data: String): Boolean{
        try{
            val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
            val ed: SharedPreferences.Editor = sPref.edit()
            ed.putString(key, data)
            ed.apply()
            return true
        }catch (ex : Exception) {return false}
    }

    fun getDataPerson(view: View) {
        //Поле для вывода ошибки
        val textError = findViewById<TextView>(R.id.textError)
        var errorCode: Int = 0;
        //try ловит ошибки с веденными данными
        try {
            //получаем параметры человека
            val ves = findViewById<EditText>(R.id.ves)
            val rost = findViewById<EditText>(R.id.rost)
            val old = findViewById<EditText>(R.id.old)
            val rbMan = findViewById<RadioButton>(R.id.rbMan)
            val rbMin =  findViewById<RadioButton>(R.id.min)
            val rbSr =  findViewById<RadioButton>(R.id.sr)
            val rbMax =  findViewById<RadioButton>(R.id.max)
            //преобразовываем данные в нужный формат

            //Сохраняем начальный вес
            val tempV: String = ves.text.toString()
            var v: Double = 0.0;
            if(tempV != "") {
                v = tempV.toDouble()
                if(v <= 0 )
                {
                    errorCode = 1;
                }
                else
                saveData("VES", v.toString())
            }
            else
            {
                errorCode = 1;
            }
            //Сохраняем начальный рост
            val tempR: String = rost.text.toString()
            var r: Double = 0.0
            if(tempR != "") {
                r = tempR.toDouble()
                if(r <= 0 )
                {
                    errorCode = 2;
                }
                else
                    saveData("ROST", r.toString())
            }
            else{
                errorCode = 2;
            }


            val tempO: String = old.text.toString()
            var o: Double = 0.0
            if(tempO != "") {
                o = tempO.toDouble()
                if(o < 14 )
                {
                    errorCode = 3;
                }
            }
            else{
                errorCode = 3;
            }

            val isMan: Boolean = rbMan.isChecked
            val isMin: Boolean = rbMin.isChecked
            val isMax: Boolean = rbMax.isChecked
            // расчет по формуле
            var koll: Double = 10 * v + 6.25 * r - 5 * o;
            //Пол
            if(isMan)
            {
                koll += 5
            }
            else
            {
                koll -=161
            }
            //Активность
            if(isMin)
            {
                koll *= 1.2
                saveData("A", "Низкая активность")
            }
            else if(isMax)
            {
                koll *= 1.55
                saveData("A", "Высокая активность")
            }
            else
            {
                koll *= 1.9
                saveData("A", "Нормальная активность")
            }
            if(errorCode > 0)
                koll = 0.0
            //сохраняем норму калорий
            if (!saveData("NORM", koll.toString()))
                    textError.text = "Не удалось сохранить данные"
                //saveData("KOLL", (0.0).toString())
            val intent = Intent(this@calcut_day_norm, MainActivity::class.java)
            if(errorCode == 1) {
                Toast.makeText(this, "Вес не может быть меньше 0", Toast.LENGTH_SHORT).show()
            }
            else if(errorCode == 2)
            {
                Toast.makeText(this, "Рост не может быть меньше 0", Toast.LENGTH_SHORT).show()
            }
            else if(errorCode == 3)
            {
                Toast.makeText(this, "Вам должно быть не меньше 14 лет", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(intent)
            }
        }catch (e: Exception)
        {
            Toast.makeText(this, "Введены неверные данные", Toast.LENGTH_SHORT).show()
        }
    }
}