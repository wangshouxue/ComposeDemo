package com.example.composedemo

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import com.example.composedemo.ui.theme.ComposeDemoTheme

class LoginActivity:ComponentActivity() {
    var nameString by mutableStateOf("")
    var pwdString by mutableStateOf("")
    var isCanClick = MutableLiveData<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                layout()
            }
        }
    }
    @Composable
    fun layout(){
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxHeight()
            .padding(start = 30.dp, end = 30.dp)) {
            titleLayout()
            nameLayout()
            pwdLayout()
            btLayout()
        }
    }
    @Composable
    fun titleLayout(){
        Text("登录", color = Color.Black,fontSize=30.sp)
    }
    @Composable
    fun nameLayout(){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp)) {
            Text("用户名：", color = Color.Black,fontSize=18.sp)
            BasicTextField(
                value = nameString,
                onValueChange = { it->
                    nameString = it
                    isCanClick.value= !TextUtils.isEmpty(nameString)&&!TextUtils.isEmpty(pwdString)
                 },
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
    @Composable
    fun pwdLayout(){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)) {
            Text("密码：  ", color = Color.Black,fontSize=18.sp)
            BasicTextField(
                value = pwdString,
                onValueChange = { it->
                    pwdString = it
                    isCanClick.value= !TextUtils.isEmpty(nameString)&&!TextUtils.isEmpty(pwdString)
                },
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
    @Composable
    fun btLayout(){
        OutlinedButton(enabled=isCanClick.value?:false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, bottom = 180.dp)
                .background(
                    color = if (isCanClick.value ?: false) colorResource(id = R.color.teal_700) else colorResource(
                        id = R.color.purple10
                    ),
                    shape = RoundedCornerShape(8.dp)
                ),
            shape = RoundedCornerShape(8.dp),
            border=null,
            onClick = {
                if (isCanClick.value?:false){
                    Toast.makeText(this,"去登录啦",Toast.LENGTH_SHORT).show()
                }
        }) {
            Text("登录", color = Color.White,fontSize=20.sp, modifier = Modifier.padding(top=5.dp, bottom = 5.dp))
        }
    }

}