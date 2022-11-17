package com.example.composedemo.commonui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.R

object MyAppTopAppBar {
    @Composable
    fun titleBarLayout(bg: Color,title:String,ic:Int?=null,clickBack: () -> Unit){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
           .background(color = bg),
            verticalAlignment=Alignment.CenterVertically) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxHeight().width(40.dp)
                .clickable {
                    clickBack()
                }){
                Image(painter= painterResource(id = R.mipmap.ic_back),
                    contentDescription = null,
                    modifier= Modifier.width(20.dp))
            }
            Text(
                text = title,
                color = Color.Black,
                fontSize = 20.sp,
                textAlign=Center,
                modifier= Modifier.weight(1f)
            )
            if (ic!=null){
                Image(painter= painterResource(id = ic),
                    contentDescription = null,
                    modifier= Modifier
                        .padding(10.dp))
            }else{
                Spacer(modifier =Modifier
                    .padding(10.dp))
            }

        }

    }
}