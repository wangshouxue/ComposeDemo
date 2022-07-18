package com.example.composedemo.fragmentui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composedemo.R

@Composable
fun forumLayout(){
    Image(painter= painterResource(id = R.mipmap.ic_praise),
        contentDescription = null,
        modifier= Modifier.padding(150.dp))
}