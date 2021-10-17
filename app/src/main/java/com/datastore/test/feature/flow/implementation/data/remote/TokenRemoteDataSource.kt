package com.datastore.test.feature.flow.implementation.data.remote

class TokenRemoteDataSource {

    suspend fun login(login:String,password:String):String{
        return "someToken"
    }
}