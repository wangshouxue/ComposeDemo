package com.example.composedemo.listener

import android.os.CountDownTimer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

object AdListenerManager: LifecycleEventObserver {
    var adListener:AdListener?=null
    private val countDownTimer=object :CountDownTimer(5000,1000){
        override fun onTick(millisUntilFinished: Long) {
            adListener?.onTick((millisUntilFinished/1000).toInt())
        }

        override fun onFinish() {
            adListener?.enterMainActivity()
        }

    }

    fun start(){
        countDownTimer.start()
    }
    fun cancle(){
        countDownTimer.cancel()
    }

    interface AdListener{
        fun onTick(time:Int)
        fun enterMainActivity()
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_START->start()
            Lifecycle.Event.ON_DESTROY->cancle()
        }
    }
}