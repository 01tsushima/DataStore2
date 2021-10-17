package com.datastore.test.feature.flow.implementation.data.remote

interface TokenRemoteDataSource {

    suspend fun login(login:String, password:String):String
}