package com.example.composedemo.fragmentui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composedemo.ConstraintActivity
import com.example.composedemo.R

@Composable
fun circleLayout(context: Context){
    Image(painter= painterResource(id = R.mipmap.ic_fan),
        contentDescription = null,
        modifier= Modifier.padding(150.dp).clickable {
            context.startActivity(Intent(context, ConstraintActivity::class.java))
        })
}