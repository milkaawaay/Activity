package com.example.activityproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlin.math.roundToInt

class Sport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport)
    }

    //получаем значение времени из соответствующего EditText
    fun loadTimeData(): Double{
        //Образ EditText для времени
        val etTime = findViewById<EditText>(R.id.time)
        try{
            var tmp : String =  etTime.text.toString()
            var time = tmp.toDouble()
            return Math.abs(time)
        }
        catch(e: java.lang.Exception) {
            Toast.makeText(this, "Время введено не корректно", Toast.LENGTH_SHORT).show()
            return 0.0
        }
    }
    //Бег
    fun runClick(view: View) {
        //koll - значение колорий, которое сгорает за минуту тренировки
        var koll: Double = 7.0
        //получаем текущее значение коллорий
        val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val curr: String = sPref.getString("KOLL", "").toString()
        var currD: Double  = curr.toDouble()
        //Проверяем введено ли время тренировки
        var time : Double = loadTimeData()
        if(time == 0.0)
            Toast.makeText(this, "Введите время", Toast.LENGTH_SHORT).show()
        //Текущее значение колорий - кол-во колорий за минуту * время тренировки
        var currKoll: Int  = (currD - koll*time).roundToInt()
        //Сохраняем полученное значение колорий по ключу KOLL
        saveData("KOLL", currKoll.toString())
        //переход на главну. страницу
        if(time != 0.0) {
            val intent = Intent(this@Sport, MainActivity::class.java)
            startActivity(intent)
        }
    }
    //Ходьба
    fun goClick(view: View) {
        //koll - значение колорий, которое сгорает за минуту тренировки
        var koll: Double = 3.0
        //получаем текущее значение коллорий
        val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val curr: String = sPref.getString("KOLL", "").toString()
        var currD: Double  = curr.toDouble()
        //Проверяем введено ли время тренировки
        var time : Double = loadTimeData()
        if(time == 0.0)
            Toast.makeText(this, "Введите время", Toast.LENGTH_SHORT).show()
        //Текущее значение колорий - кол-во колорий за минуту * время тренировки
        var currKoll: Int  = (currD - koll*time).roundToInt()
        //Сохраняем полученное значение колорий по ключу KOLL
        saveData("KOLL", currKoll.toString())
        //переход на главну. страницу
        if(time != 0.0) {
            val intent = Intent(this@Sport, MainActivity::class.java)
            startActivity(intent)
        }
    }
    //Плавание
    fun swimmClick(view: View) {
        //koll - значение колорий, которое сгорает за минуту тренировки
        var koll: Double = 3.0
        //получаем текущее значение коллорий
        val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val curr: String = sPref.getString("KOLL", "").toString()
        var currD: Double  = curr.toDouble()
        //Проверяем введено ли время тренировки
        var time : Double = loadTimeData()
        if(time == 0.0)
            Toast.makeText(this, "Введите время", Toast.LENGTH_SHORT).show()
        //Текущее значение колорий - кол-во колорий за минуту * время тренировки
        var currKoll: Int  = (currD - koll*time).roundToInt()
        //Сохраняем полученное значение колорий по ключу KOLL
        saveData("KOLL", currKoll.toString())
        //переход на главну. страницу
        if(time != 0.0) {
            val intent = Intent(this@Sport, MainActivity::class.java)
            startActivity(intent)
        }
    }
    //Беговая дорожка
    fun runDClick(view: View) {
        //koll - значение колорий, которое сгорает за минуту тренировки
        var koll: Double = 6.0
        //получаем текущее значение коллорий
        val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val curr: String = sPref.getString("KOLL", "").toString()
        var currD: Double  = curr.toDouble()
        //Проверяем введено ли время тренировки
        var time : Double = loadTimeData()
        if(time == 0.0)
            Toast.makeText(this, "Введите время", Toast.LENGTH_SHORT).show()
        //Текущее значение колорий - кол-во колорий за минуту * время тренировки
        var currKoll: Int  = (currD - koll*time).roundToInt()
        //Сохраняем полученное значение колорий по ключу KOLL
        saveData("KOLL", currKoll.toString())
        //переход на главну. страницу
        if(time != 0.0) {
            val intent = Intent(this@Sport, MainActivity::class.java)
            startActivity(intent)
        }
    }
    //Велотренажер
    fun cycleTrenClick(view: View) {
        //koll - значение колорий, которое сгорает за минуту тренировки
        var koll: Double = 12.0
        //получаем текущее значение коллорий
        val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val curr: String = sPref.getString("KOLL", "").toString()
        var currD: Double  = curr.toDouble()
        //Проверяем введено ли время тренировки
        var time : Double = loadTimeData()
        if(time == 0.0)
            Toast.makeText(this, "Введите время", Toast.LENGTH_SHORT).show()
        //Текущее значение колорий - кол-во колорий за минуту * время тренировки
        var currKoll: Int  = (currD - koll*time).roundToInt()
        //Сохраняем полученное значение колорий по ключу KOLL
        saveData("KOLL", currKoll.toString())
        //переход на главну. страницу
        if(time != 0.0) {
            val intent = Intent(this@Sport, MainActivity::class.java)
            startActivity(intent)
        }
    }
    //Эллиптический тренажер
    fun ellipTrenClick(view: View) {
        //koll - значение колорий, которое сгорает за минуту тренировки
        var koll: Double = 7.0
        //получаем текущее значение коллорий
        val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val curr: String = sPref.getString("KOLL", "").toString()
        var currD: Double  = curr.toDouble()
        //Проверяем введено ли время тренировки
        var time : Double = loadTimeData()
        if(time == 0.0)
            Toast.makeText(this, "Введите время", Toast.LENGTH_SHORT).show()
        //Текущее значение колорий - кол-во колорий за минуту * время тренировки
        var currKoll: Int  = (currD - koll*time).roundToInt()
        //Сохраняем полученное значение колорий по ключу KOLL
        saveData("KOLL", currKoll.toString())
        //переход на главну. страницу
        if(time != 0.0) {
            val intent = Intent(this@Sport, MainActivity::class.java)
            startActivity(intent)
        }
    }
    //Силовая тернировка
    fun forceClick(view: View) {
        //koll - значение колорий, которое сгорает за минуту тренировки
        var koll: Double = 6.0
        //получаем текущее значение коллорий
        val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val curr: String = sPref.getString("KOLL", "").toString()
        var currD: Double  = curr.toDouble()
        //Проверяем введено ли время тренировки
        var time : Double = loadTimeData()
        if(time == 0.0)
            Toast.makeText(this, "Введите время", Toast.LENGTH_SHORT).show()
        //Текущее значение колорий - кол-во колорий за минуту * время тренировки
        var currKoll: Int  = (currD - koll*time).roundToInt()
        //Сохраняем полученное значение колорий по ключу KOLL
        saveData("KOLL", currKoll.toString())
        //переход на главну. страницу
        if(time != 0.0) {
            val intent = Intent(this@Sport, MainActivity::class.java)
            startActivity(intent)
        }
    }
    //Круговая тренировка
    fun circleClick(view: View) {
        //koll - значение колорий, которое сгорает за минуту тренировки
        var koll: Double = 7.0
        //получаем текущее значение коллорий
        val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val curr: String = sPref.getString("KOLL", "").toString()
        var currD: Double  = curr.toDouble()
        //Проверяем введено ли время тренировки
        var time : Double = loadTimeData()
        if(time == 0.0)
            Toast.makeText(this, "Введите время", Toast.LENGTH_SHORT).show()
        //Текущее значение колорий - кол-во колорий за минуту * время тренировки
        var currKoll: Int  = (currD - koll*time).roundToInt()
        //Сохраняем полученное значение колорий по ключу KOLL
        saveData("KOLL", currKoll.toString())
        //переход на главну. страницу
        if(time != 0.0) {
            val intent = Intent(this@Sport, MainActivity::class.java)
            startActivity(intent)
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

    fun btnSportMainMenuClick(view: View) {
        val intent = Intent(this@Sport, MainActivity::class.java)
        startActivity(intent)
    }
    fun btnSportSportMenuClick(view: View) {
        val intent = Intent(this@Sport, Sport::class.java)
        startActivity(intent)
    }
    fun btnDishesMainMenuClick(view: View) {
        val intent = Intent(this@Sport, Dishes::class.java)
        startActivity(intent)
    }
    fun btnFoodMenuClick(view: View) {
        val intent = Intent(this@Sport, Food::class.java)
        startActivity(intent)
    }
    //Переход к шагомеру
    fun goStepPage(view: View) {
        val intent = Intent(this@Sport, stepCount::class.java)
        startActivity(intent)
    }

    fun goMap(view: View) {
        val intent = Intent(this@Sport, MapsActivity::class.java)
        startActivity(intent)
    }
}