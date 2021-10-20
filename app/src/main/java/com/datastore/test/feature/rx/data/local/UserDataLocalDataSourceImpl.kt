package com.datastore.test.feature.rx.data.local

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.rxjava2.RxDataStore
import com.datastore.test.PreferenceKeys
import com.datastore.test.feature.rx.domain.model.UserLoginModel
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class UserDataLocalDataSourceImpl @Inject constructor(
    private val dataStore: RxDataStore<Preferences>
) : UserDataLocalDataSource {

    override fun fetchData(): Flowable<UserLoginModel> {
        return dataStore.data().map {
            UserLoginModel(
                login = it[PreferenceKeys.User.FIELD_LOGIN] ?: "",
                password = it[PreferenceKeys.User.FIELD_PASSWORD] ?: ""
            )
        }
    }


    override suspend fun saveData(data: UserLoginModel) {
        dataStore.updateDataAsync { prefsIn ->
            val mutablePreferences = prefsIn.toMutablePreferences()
            mutablePreferences[PreferenceKeys.User.FIELD_LOGIN] = data.login
            mutablePreferences[PreferenceKeys.User.FIELD_PASSWORD] = data.password
            Single.just(mutablePreferences)
        }
    }
}