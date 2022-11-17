package com.example.composedemo.net

class Response<T>(
    val data: T?,
    val code: Int,
    val msg: String
)