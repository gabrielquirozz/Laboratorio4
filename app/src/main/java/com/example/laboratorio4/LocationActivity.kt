package com.example.laboratorio4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.laboratorio4.R
import com.example.laboratorio4.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_location.*


class LocationActivity : AppCompatActivity() {

    lateinit var titleText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        val title_text2 = intent.getStringExtra("LOCATION")
        val phrase_text2 = intent.getStringExtra("PHRASE")
        val description_text2 = intent.getStringExtra("DESCRIPTION")

        title_text.text = title_text2
        sub_title_text.text = phrase_text2
        description_text.text = description_text2

        comment_button.setOnClickListener {
            val resultIntent:Intent = Intent()
            var s:String= comment_text.text.toString()
            resultIntent.putExtra("TOAST_MESSAGE", comment_text.text.toString())
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
