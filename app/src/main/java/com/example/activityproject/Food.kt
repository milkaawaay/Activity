package com.example.activityproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlin.math.abs

class Food : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
    }

    fun addProductClick(view: View) {
        //Получаем образы EditText для кол-ва колорий в продукте и веса продукта
        try {
        val etProdActiv = findViewById<EditText>(R.id.etProductActiv)
        val etProdVes = findViewById<EditText>(R.id.etProductVes)
        var tmpProdActiv : String = etProdActiv.text.toString()
        //Преобразовываем вес
        val tempV: String = etProdVes.text.toString()
        var v: Double = 0.0;
        if(tempV != "") {
            v = tempV.toDouble()
        }
        //Преобразовываем колорийность
        val tempA: String = etProdActiv.text.toString()
        var a: Double = 0.0;
        if(tempA != "") {
            a = tempA.toDouble()
        }
            //Переводим данные в тип double
            var productActiv : Double = tmpProdActiv.toDouble()
            //получаем текущее значение колорий
            val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
            val curr: String = sPref.getString("KOLL", "").toString()
            var currD : Double = 0.0
            if(curr != "")
                currD = curr.toDouble()
            else
                currD = 0.0
            //Текущее значение колорий + кол-во колорий за 100 г. * вес продукта в граммах
            var currKoll: Double  = currD + Math.abs((a * v)/100)
            //Сохраняем полученное значение колорий по ключу KOLL
            saveData("KOLL", currKoll.toString())
            Toast.makeText(this, "Продукт успешно добавлен", Toast.LENGTH_SHORT).show()
            //переход на главну. страницу
            val intent = Intent(this@Food, MainActivity::class.java)
            startActivity(intent)
        }catch (e : Exception)
        {
            Toast.makeText(this, "Проверте введенные данные", Toast.LENGTH_SHORT).show()
        }
    }
    //метод для сохраниения изменений в файле настроек
    //return true if saving successfully
    //return false otherwise
    fun saveData( key : String, data: String): Boolean{
        try{
            val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
            val ed: SharedPreferences.Editor = sPref.edit()
            ed.putString(key, data)
            ed.apply()
            return true
        }catch (ex : Exception) {return false}
    }
    //Функциональность кнопок меню - переход к другим окнам

    //Переход к главной странице
    fun btnMainFromFoodClick(view: View) {
        val intent = Intent(this@Food, MainActivity::class.java)
        startActivity(intent)
    }
    //Переход к тренировкам
    fun btnSportFromFoodClick(view: View) {
        val intent = Intent(this@Food, Sport::class.java)
        startActivity(intent)
    }
    //Переход к рецептам
    fun btnDishesFromFoodClick(view: View) {
        val intent = Intent(this@Food, Dishes::class.java)
        startActivity(intent)
    }
    //Переход к дневнику питания
    fun btnFoodFromFoodClick(view: View) {
        val intent = Intent(this@Food, Food::class.java)
        startActivity(intent)
    }
}