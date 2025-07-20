package com.example.moody

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner: Spinner = findViewById(R.id.moodList)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.moodList,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

    }

    fun goToMoodyMessage(view: View) {

        val nameInput = findViewById<EditText>(R.id.inputTextView)
        val name = nameInput.editableText.toString()
        val moodSpinner = findViewById<Spinner>(R.id.moodList)
        val mood = moodSpinner.selectedItem.toString()

        val intent = Intent(this, MoodyMessage::class.java)
        intent.putExtra(MoodyMessage.NAME_INPUT, name)
        intent.putExtra(MoodyMessage.MOOD_INPUT, mood)
        startActivity(intent)

    }
}