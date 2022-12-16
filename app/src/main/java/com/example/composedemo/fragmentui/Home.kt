package com.example.composedemo.fragmentui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composedemo.R

@Composable
fun homeLayout(){
    Image(painter= painterResource(id = R.mipmap.img),
        contentDescription = null,
        modifier= Modifier.padding(150.dp))
}