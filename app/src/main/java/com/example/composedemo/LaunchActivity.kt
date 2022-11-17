package com.example.composedemo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.composedemo.listener.AdListenerManager

class LaunchActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textview= TextView(this)
        textview.textSize=60f
        textview.setTextColor(Color.WHITE)
        setContentView(textview)
        AdListenerManager.adListener=object: AdListenerManager.AdListener{
            override fun onTick(time: Int) {
                textview.text="跳过$time"
            }

            override fun enterMainActivity() {
                startActivity(Intent(this@LaunchActivity, MainActivity::class.java))
                finish()
            }
        }
        lifecycle.addObserver(AdListenerManager)
    }

}