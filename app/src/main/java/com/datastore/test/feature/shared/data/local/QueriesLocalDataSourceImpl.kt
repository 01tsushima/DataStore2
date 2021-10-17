package com.datastore.test.feature.shared.data.local

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QueriesLocalDataSourceImpl
@Inject constructor(
    private val context: Context
) : QueriesLocalDataSource {

    private val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun saveQuery(query: String) {
        val data = fetchData() + query
        val newQueriesString = data.joinToString(",")
        val editor = sharedPref.edit()
        editor.putString(QUERY_SET, newQueriesString)

        //меняет данные на диске синхронно
        //editor.commit()

        //меняет данные в виртуальной памяти сразу же,
        // записывает на диск асинхронно
        editor.apply()
    }

    override fun fetchQuery(): Flow<Set<String>> = flow { fetchData() }

    private fun fetchData(): Set<String> {
        return sharedPref.getString(QUERY_SET, null)?.split(",")?.toSet() ?: emptySet()
    }

    companion object {
        private const val SHARED_PREF_NAME = "sharedPref"
        private const val QUERY_SET = "querySet"
    }
}