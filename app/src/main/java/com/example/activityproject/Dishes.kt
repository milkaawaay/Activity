package com.example.activityproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_COMPACT
import android.view.View
import android.widget.TextView

class Dishes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dishes)
        //вызов формирования списка рецептов
        createDishesList()
    }

    fun btnBackMenuClick(view: View) {
        //Переход на главную страницу
        val intent = Intent(this@Dishes, MainActivity::class.java)
        startActivity(intent)
    }
    fun createDishesList()
    {
        //Получаем образ TextView для вывода рецептов
        val dishesText = findViewById<TextView>(R.id.dishesData)
        //Перменная для записи списков продуктов в формате html
        var htmlDish : String =""
        //Парсинг xml - файла с записями рецептов
        val xpp = getResources().getXml(R.xml.dishes)
        val parser = MenuResourceParser()
        //Формируем html запись
        if (parser.parse(xpp))
        {
            for( prod in parser.getDishes()){
                //пример записи:
                //<h3>Название блюда</h3>
                //<p><i>Описание рецепта</i></p>
                // </br>
                htmlDish += "<h1 align=\"center\">"  + prod.name + "</h1>"
                htmlDish += "<p><i>" + prod.value + "</i></p>"
                htmlDish += "</br>"
            }
        }
        //Заносим данные в TextView
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
        {
            dishesText.setText(Html.fromHtml(htmlDish,Html.FROM_HTML_MODE_LEGACY));
        }
        else {
            dishesText.setText(Html.fromHtml(htmlDish));
        }
    }
}