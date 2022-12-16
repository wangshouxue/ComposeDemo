package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * @Description: 类作用描述
 */
class ConstraintActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            constrainDemo()
        }
    }
    @Composable
    fun constrainDemo(){
        ConstraintLayout(modifier = Modifier.fillMaxSize()){
            val (button,text,button2)=createRefs()
            Button(onClick = { }, modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
                absoluteLeft.linkTo(parent.absoluteLeft)
                absoluteRight.linkTo(parent.absoluteRight)
            }) {
                Text(text = "button")
            }
            Text(text = "text", modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
                centerAround(button.end)  //Text的中线和Button的end对⻬
            })
            // 根据button和text的end（取其⻓）创建barrier（在button, text的右侧）
            val barrier = createEndBarrier(button, text)
            // Button2显示在barrier开始处
            Button(
                onClick = {},
                modifier = Modifier.constrainAs(button2) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(barrier)
                }
            ) {
                Text("Button2")
            }

            val guideline = createGuidelineFromStart(0.2f)
            val (box1, box2) = createRefs()
            Box( // 创建了两个Box布局，分别是结束部分链接到引导线，开始部分链接到引导线。
            modifier = Modifier.fillMaxWidth().height(50.dp)
                .background(color = Yellow)
                .constrainAs(box1) {
                    end.linkTo(guideline)
                    top.linkTo(parent.top, margin = 200.dp)
                }
            )
            Box(
                modifier = Modifier.fillMaxWidth().height(50.dp)
                    .background(color = Red)
                    .constrainAs(box2) {
                        start.linkTo(guideline)
                        top.linkTo(parent.top, margin = 200.dp)
                    }
            )

        }
    }


}