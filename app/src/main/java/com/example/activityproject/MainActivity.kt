package com.example.activityproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Читаем данные из настроек
        loadText();
    }
    //Загрузка данных из файла настроек
    fun loadText() {
        //Получаем образы элементов главного меню
        val etVes = findViewById<TextView>(R.id.twVes)
        val etActiv = findViewById<TextView>(R.id.twActiw)
        val progress = findViewById<ProgressBar>(R.id.progress)
        val etProgress = findViewById<TextView>(R.id.twProgress)
        //Получаем значения из файла настроек
        val sPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val svVes: String = sPref.getString("VES", "").toString()
        val svActiv: String = sPref.getString("A", "").toString()
        val norm: String = sPref.getString("NORM", "").toString()
        val curr: String = sPref.getString("KOLL", "").toString()
        etVes.text = svVes
        etActiv.text = svActiv
        //Заполняем значение текущих колорий и колорий и нормы для человека
        //Колличество калорий в формате (сейчас/норма)
        var normInt = norm.toDouble()
        var currInt : Int = 0
        if(curr == "")
        {
            var s:String = ("0/" + norm)
            etProgress.text =  s
        }
        else
        {
            currInt = (Math.round(curr.toDouble() * 10.0) / 10.0).roundToInt()
            var s:String = (currInt.toString() + "/" + norm)
            etProgress.text = s
        }
        //Прогресс в виде ProgressBar
        progress.setMax(normInt.roundToInt())
        progress.setProgress(currInt)
        //Всплывающее окно в случае выполнения нормы
        if(currInt >= normInt)
            Toast.makeText(this, "Поздравляем!!!\n Вы достигли нормы", Toast.LENGTH_SHORT).show()
    }

    //Функциональность кнопок меню - переход к другим окнам

    //Переход к главной странице
    fun btbGoMenu(view: View) {
        val intent = Intent(this@MainActivity, MainActivity::class.java)
        startActivity(intent)
    }
    //Переход к тренировкам
    fun goTren(view: View) {
        val intent = Intent(this@MainActivity, Sport::class.java)
        startActivity(intent)
    }
    //Переход к списку рецептов
    fun btnGoDishes(view: View) {
        val intent = Intent(this@MainActivity, Dishes::class.java)
        startActivity(intent)
    }
    //Переход к денвнику продуктов
    fun btnGoProductDiary(view: View) {
        val intent = Intent(this@MainActivity, Food::class.java)
        startActivity(intent)
    }
    fun goToSettings(view: View) {
        val intent = Intent(this@MainActivity, calcut_day_norm::class.java)
        startActivity(intent)
    }

}