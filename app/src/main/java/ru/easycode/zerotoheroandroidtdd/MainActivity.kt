package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    //Определяем типа объект-интерфейс с типом Initial
    private  var state: State = State.Initial
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
            state = State.Removed   //Меняем наш state на Removed
            state.apply(linearLayout,textView, button)  //Выполняем функцию которая удалит textView

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY_textView, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY_textView, State::class.java) as State
        state.apply(linearLayout, textView, button)
    }

    companion object{
        private const val KEY_textView = "key1"
        private const val KEY_button = "key2"
    }

    interface State: Serializable {

        fun apply (linearLayout: LinearLayout, textView: TextView, button: Button)
        object Initial : State {
            override fun apply(linearLayout: LinearLayout, textView: TextView, button: Button) = Unit
        }

        object Removed : State {
            override fun apply(linearLayout: LinearLayout, textView: TextView, button: Button) {
                linearLayout.removeView(textView)
                button.isEnabled = false
            }
        }
    }
}