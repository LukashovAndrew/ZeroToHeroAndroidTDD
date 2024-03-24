package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var    textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.changeButton)
        textView = findViewById(R.id.titleTextView)
        button.setOnClickListener {
            textView.setText("I am an Android Developer!")
        }

        savedInstanceState?.let {
            textView.text = savedInstanceState.getString("key")
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("key", textView.text.toString())
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        textView.text = savedInstanceState.getString("key")
//    }

    override fun onDestroy() {
        super.onDestroy()
    }
}