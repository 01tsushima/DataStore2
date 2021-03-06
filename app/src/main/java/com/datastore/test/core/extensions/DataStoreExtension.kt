package com.datastore.test.core.extensions

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.google.crypto.tink.Aead
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.ObjectOutputStream

fun <T> DataStore<Preferences>.getOnes(key: Preferences.Key<T>) = runBlocking { get(key).first() }

fun <T> DataStore<Preferences>.getOnes(key: Preferences.Key<T>, defaultValue: T) =
    runBlocking { get(key, defaultValue).first() }

fun <T> DataStore<Preferences>.get(key: Preferences.Key<T>, defaultValue: T) = data
    .catch { if (it is IOException) emit(emptyPreferences()) else throw it }
    .map { it[key] ?: defaultValue }

fun <T> DataStore<Preferences>.get(key: Preferences.Key<T>) = data
    .catch { if (it is IOException) emit(emptyPreferences()) else throw it }
    .map { it[key] }

suspend fun <T> DataStore<Preferences>.put(key: Preferences.Key<T>, value: T) {
    edit {
        it[key] = value
    }
}

suspend fun DataStore<Preferences>.hasKey(key: Preferences.Key<*>) = this.edit { it.contains(key) }

suspend fun DataStore<Preferences>.clearDataStore() {
    edit {
        it.clear()
    }
}

