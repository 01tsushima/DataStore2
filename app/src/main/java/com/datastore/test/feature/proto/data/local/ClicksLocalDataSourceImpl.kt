package com.datastore.test.feature.proto.data.local

import androidx.datastore.core.DataStore
import com.datastore.test.UserPreference
import com.datastore.test.UserPrefs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ClicksLocalDataSourceImpl
@Inject constructor(
    private val dataStore: DataStore<UserPreference>,
) : ClicksLocalDataSource {

    override suspend fun onNewClick() {
        dataStore.updateData { preferences ->
            var oldValue = preferences.tapScores
            preferences.toBuilder().setTapScores(oldValue + 1).build()
        }
    }

    override fun fetchClicks(): Flow<Int> = dataStore.data.map { preferences ->
        preferences.tapScores
    }


}