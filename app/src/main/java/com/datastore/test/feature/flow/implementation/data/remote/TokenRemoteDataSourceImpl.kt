package com.datastore.test.feature.flow.implementation.data.remote

import javax.inject.Inject

class TokenRemoteDataSourceImpl @Inject constructor():TokenRemoteDataSource {

    override suspend fun login(login:String,password:String):String{
        return "new Token"
    }
}