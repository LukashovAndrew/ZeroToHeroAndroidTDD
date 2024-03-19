package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val button = findViewById<Button>(R.id.changeButton)  - generic типизация
        val button : Button = findViewById(R.id.changeButton)   //без джинерик типизации
        val textView = findViewById<TextView>(R.id.titleTextView)

        button.setOnClickListener {
            textView.setText("I am an Android Developer!")
        }
    }
}