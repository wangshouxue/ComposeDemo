package com.example.composedemo.fragmentui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composedemo.LoginActivity

@Composable
fun myLayout(context: Context){
    Text(color = Color.White, text = "我的", modifier = Modifier.padding(100.dp).clickable {
        context.startActivity(Intent(context, LoginActivity::class.java))
    })
}