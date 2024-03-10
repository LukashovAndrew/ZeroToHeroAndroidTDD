package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val linearLayout = LinearLayout(this)
        val textView = TextView(this)
        textView.id = R.id.titleTextView
        textView.text = R.string.main_logo.toString()
        linearLayout.addView(textView)

        setContentView(R.layout.activity_main)
    }
}