package com.example.composedemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TableRow
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.beans.MainEntity
import com.example.composedemo.fragmentui.*
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.ui.theme.MyAppTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    var selectMap = mutableStateMapOf<String, Boolean>()
    //通过by引⽤的对象，在取值和赋值的时候均会调⽤ 代理类的getValue 和 setValue⽅法
    var currentItem by mutableStateOf("home")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                val list= mutableListOf<MainEntity>()
                list.add(MainEntity("首页","home"))
                list.add(MainEntity("圈子","circle"))
                list.add(MainEntity("社区","forum"))
                list.add(MainEntity("消息","msg"))
                list.add(MainEntity("我的","my"))
                tabLayout(list)

            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun tabLayout(list:MutableList<MainEntity>) {
        Scaffold(
            bottomBar = {
                NavigationBar(containerColor= Color.White,contentColor=Color.Transparent) {
                    for (bean in list) {
                        NavigationBarItem(
                            colors=NavigationBarItemDefaults.colors(indicatorColor=Color.White),
                            selected = (selectMap.get(bean.name) ?: false),
                            onClick = {
                                for (j in selectMap.keys) {
                                    selectMap.put(j, false)
                                }
                                selectMap.put(bean.name, true)
                                currentItem=bean.direct
                            },
                            icon = {
                                        Icon(
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .size(25.dp),
                                        painter=painterResource(id = R.mipmap.ic_at),
                                        contentDescription = null,
                                        tint = if (selectMap.get(bean.name)?:false) colorResource(id = R.color.color_ff9800) else Color.Black)
                            },
                            label = {
                                Text(
                                    text = "${bean.name}",
                                    color = if (selectMap.get(bean.name) ?: false) colorResource(id = R.color.color_ff9800) else Color.Black
                                )
                            })
                    }
                }
            },
            containerColor = MaterialTheme.colorScheme.tertiary
        )
        {
            when (currentItem){
                "home"-> homeLayout()
                "circle"->circleLayout()
                "forum"-> forumLayout()
                "msg"->msgLayout()
                "my"->myLayout()
            }
//            Box(modifier = Modifier.fillMaxSize()) {
//                Text(color = Color.Black, modifier = Modifier.align(Alignment.Center), text = "内容")
//            }
//
        }
        selectMap.put("首页", true)
    }


}