package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayout: LinearLayout
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        val button = findViewById<Button>(R.id.removeButton)

        button.setOnClickListener{
            linearLayout.removeView(textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removedTextView = linearLayout.childCount == 1
        outState.putBoolean(KEY, removedTextView)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removedTextView = savedInstanceState.getBoolean(KEY)
        if (removedTextView)
            linearLayout.removeView(textView)
    }

    companion object {
        private const val KEY = "key"
    }
}