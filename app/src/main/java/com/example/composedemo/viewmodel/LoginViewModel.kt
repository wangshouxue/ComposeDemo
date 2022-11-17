package com.example.composedemo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.composedemo.api.LoginApi
import com.example.composedemo.beans.MainEntity
import com.example.composedemo.net.RetrofitClient
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class LoginViewModel(application: Application): AndroidViewModel(application) {
    val api by lazy { RetrofitClient.getRetrofit().create(LoginApi::class.java) }
    var articlesLiveData: MutableLiveData<MainEntity> = MutableLiveData()
    var apiError:MutableLiveData<Throwable> = MutableLiveData()

//    private val itemId = MutableLiveData<String>()
//    val result = itemId.switchMap {
//        liveData { emit(fetchItem(it)) }
//    }

    fun login(){
        val exception = CoroutineExceptionHandler { coroutineContext, throwable ->
            apiError.postValue(throwable)
//            Log.i("CoroutinesViewModel",throwable.message!!)
        }
        viewModelScope.launch(exception) {
            val respose = api.goLogin(1)
            if (respose.code == 0) {
                articlesLiveData.postValue(respose.data)
            } else {
                articlesLiveData.postValue(null)
            }
        }
    }
}