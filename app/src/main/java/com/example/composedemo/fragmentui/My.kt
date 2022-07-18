package com.example.composedemo.fragmentui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun myLayout(){
    Text(color = Color.White, text = "我的", modifier = Modifier.padding(100.dp))
}