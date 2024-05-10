package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    private lateinit var linearLayout: LinearLayout
    private lateinit var textView: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        button = findViewById<Button>(R.id.removeButton)

        button.setOnClickListener {
            linearLayout.removeView(textView)
            button.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removedTextView = linearLayout.childCount == 1 //textView.isInLayout
        val enabledButton = button.isEnabled
        outState.putBoolean(KEY_textView, removedTextView)
        outState.putBoolean(KEY_button, enabledButton)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removedTextView = savedInstanceState.getBoolean(KEY_textView)
        val enabledButton = savedInstanceState.getBoolean(KEY_button)
        if(removedTextView)
            linearLayout.removeView(textView)
        if(!enabledButton)
            button.isEnabled = false
    }

companion object{
    private const val KEY_textView = "key"
    private const val KEY_button = "key"
}
}