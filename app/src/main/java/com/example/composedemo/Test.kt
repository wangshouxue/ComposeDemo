package com.example.composedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * @Description: 类作用描述
 */
class Test: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldDemo()
//            MyTabRow({},0)
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScaffoldDemo() {
        val context = LocalContext.current
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            //抽屉组件区域
            drawerContent = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "抽屉组件中内容")
                }
            },
            //标题栏区域
            topBar = {
                SmallTopAppBar(
                    title = { Text(text = "脚⼿架示例") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                Toast.makeText(context, "click！！", Toast.LENGTH_LONG).show()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = null
                            )
                        }
                    }
                )
            },
            //悬浮
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("悬浮按钮") },
                    onClick = { }
                )},
            floatingActionButtonPosition = FabPosition.End,
            //屏幕内容区域
            content= {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "屏幕内容区域")
                }
            }
        )
    }


//    @Composable
//    fun MyTabRow(
//        onTabItemClick: (name: String) -> Unit,
//        indexDefault: Int = 0
//    ) {
//        val indexState = remember {
//            mutableStateOf(indexDefault)
//        }
//        val colorsTab = arrayOf("blue", "red", "green", "yellow")
//        TabRow(
//            selectedTabIndex = indexState.value,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(46.dp),
//            backgroundColor = MaterialTheme.colorScheme.primary
//        ) {
//            for ((index, name) in colorsTab.withIndex()) {
//                Tab(
//                    selected = index == indexState.value,
//                    onClick = {
//                        indexState.value = index
//                        onTabItemClick(colorsTab[index])
//                    },
//                    modifier = Modifier.fillMaxHeight()) {
//                    Text(text = name,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .wrapContentHeight(),
//                        textAlign = TextAlign.Center
//                    )
//                }
//            }
//        }
//    }

}