package com.example.moody

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoodyMessage : AppCompatActivity() {
    companion object{
        const val NAME_INPUT = "name_input"
        const val MOOD_INPUT = "user_input"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_moody_message)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra(NAME_INPUT)
        val mood = intent.getStringExtra(MOOD_INPUT)

        val message = when (mood) {
            "Happy" -> "Feeling happy, $name? Must’ve forgotten about your career, huh!!"
            "Chill" -> "You’re the human version of lo-fi beats and iced coffee, $name!!"
            "Angry" -> "$name, Punch the Wall near you as hard as you can!! Anger will Go in a second!!"
            "Excited" -> "Zyada Excited mat ho $name bro, apni kismat Jethalal se kam nahi hai!!"
            "Moody" -> "POV: You’re feeling everything and nothing at the same time, right $name!!"
            "Sad" -> "Even the moon has phases. You’ll shine again $name!!"
            "Tired" -> "ZINDA LAASH HAI KYA!!!"
            else -> "Hey $name, you're one of a kind!!"
        }
        val messageTextView = findViewById<TextView>(R.id.messageTextView)
        messageTextView.text = message

        val emojiRes = when (mood) {
            "Happy" -> R.drawable.emoji_happy
            "Sad" -> R.drawable.emoji_sad
            "Angry" -> R.drawable.emoji_angry
            "Tired" -> R.drawable.emoji_tired
            "Chill" -> R.drawable.emoji_cool
            "Moody" -> R.drawable.emoji_moody
            "Excited" -> R.drawable.emoji_excited
            else -> R.drawable.emoji_default
        }
        val emojiView = findViewById<ImageView>(R.id.emojiView)
        emojiView.setImageResource(emojiRes)
    }
}