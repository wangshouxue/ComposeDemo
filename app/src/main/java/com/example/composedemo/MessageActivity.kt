package com.example.composedemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.beans.MsgEntity
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                Column{
                    msgTypeLayout()
                    conversation(getMsg())
                }
                
            }
        }
    }
    @Composable
    fun msgTypeLayout(){
        Surface(
            shape = RoundedCornerShape(6.dp),
            shadowElevation = 8.dp,  // 高度
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .height(113.dp),  // 外边距
        ){
            Row(horizontalArrangement=Arrangement.SpaceEvenly,verticalAlignment = Alignment.CenterVertically,modifier = Modifier
                .padding(18.dp)
                .fillMaxSize()) {
                Box(contentAlignment=Alignment.TopEnd){
                    Column(horizontalAlignment=Alignment.CenterHorizontally) {
                        Image(painter = painterResource(R.mipmap.ic_at),contentDescription = "at")
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text ="@我的" )
                    }
                    Text(text ="99+",color=Color.White,fontSize=10.sp, modifier = Modifier
                        .background(color = Color.Red, shape = CircleShape)
                        .padding(horizontal = 5.dp, vertical = 1.dp))
                }

                Column(horizontalAlignment=Alignment.CenterHorizontally) {
                    Image(painter = painterResource(R.mipmap.ic_comment),contentDescription = "comment")
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text ="评论" )
                }

                Box(contentAlignment=Alignment.TopEnd){
                    Column(horizontalAlignment=Alignment.CenterHorizontally) {
                        Image(painter = painterResource(R.mipmap.ic_praise),contentDescription = "praise")
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text ="点赞" )
                    }
                    Text(text ="9",color=Color.White,fontSize=10.sp, modifier = Modifier
                        .background(color = Color.Red, shape = CircleShape)
                        .padding(horizontal = 5.dp, vertical = 1.dp))
                }

                Column(horizontalAlignment=Alignment.CenterHorizontally) {
                    Image(painter = painterResource(R.mipmap.ic_fan),contentDescription = "fan")
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text ="粉丝" )
                }
            }
        }
    }

    @Composable
    fun conversation(messages: List<MsgEntity>) {
        LazyColumn {
            items(messages) { message ->
                msgLayout(message)
            }
        }
    }
    @Composable
    fun msgLayout(message: MsgEntity){
        Column(
            Modifier
                .clickable {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("name", message.name)
                    startActivity(intent)
                }
                .fillMaxWidth()){
            Row(verticalAlignment=Alignment.CenterVertically,modifier=Modifier.padding(15.dp)) {
                Box(contentAlignment=Alignment.TopEnd){
                    Image(painter = painterResource(R.mipmap.img),contentDescription = "avatar")
                    if (message.count>0){
                        Text(text ="${message.count}",color=Color.White,fontSize=10.sp, modifier = Modifier
                            .background(color = Color.Blue, shape = CircleShape)
                            .padding(horizontal = 5.dp, vertical = 1.dp))
                    }
                }
                Column(
                    Modifier
                        .weight(weight = 1f)
                        .padding(start = 10.dp)) {
                    Text(text =message.name,color= colorResource(id = R.color.color_222222),fontSize=16.sp )
                    Text(text =message.lastMsg,color= colorResource(id = R.color.color_868D97),fontSize=12.sp)
                }
                Text(text =message.time,color= colorResource(id = R.color.color_868D97),fontSize=12.sp )
            }
            Spacer(
                Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .background(color = colorResource(id = R.color.color_e5e5e5))
                    .height(1.dp)
                    .fillMaxWidth())
        }
    }

    fun getMsg():List<MsgEntity>{
        val list= arrayListOf<MsgEntity>()
        list.add(MsgEntity("","暴走头条","你好","7-10  16:20:12"))
        list.add(MsgEntity("","小米","哈哈","7-10  15:20:12"))
        list.add(MsgEntity("","二哈哥","嗨","6-19  15:20:12",10))
        list.add(MsgEntity("","大卫","在干嘛？","2021-11-10  15:21:12"))
        list.add(MsgEntity("","心悦","等待中。。。","2021-8-10  15:25:12",2))
        list.add(MsgEntity("","柯基汪","吃肉哇","2021-7-20  15:28:12"))
        list.add(MsgEntity("","相遇","缘分","2020-7-10  11:20:12"))
        list.add(MsgEntity("","远方","有时间来看我","2020-6-10  17:20:12"))
        list.add(MsgEntity("","评论通知","暂无"))
        list.add(MsgEntity("","同乡会","谢啦","2020-4-10  19:20:12"))
        list.add(MsgEntity("","服务号","今日热点","2020-3-10  10:20:12"))
        list.add(MsgEntity("","支付通知","已消费100","2020-1-10  08:20:12"))
        return list
    }

}