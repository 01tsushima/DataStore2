package com.datastore.test.di.application

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder
import androidx.datastore.rxjava2.RxDataStore
import com.datastore.test.PreferenceKeys
import com.datastore.test.PreferenceKeys.SecureKey.KEYSET_NAME
import com.datastore.test.PreferenceKeys.SecureKey.MASTER_KEY_URI
import com.datastore.test.PreferenceKeys.SecureKey.PREFERENCE_FILE
import com.datastore.test.UserPreference
import com.datastore.test.di.scope.PerApplication
import com.datastore.test.feature.proto.data.local.UserPreferencesSerializer
import com.datastore.test.utils.dataStore
import com.google.crypto.tink.Aead
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.aead.AesGcmKeyManager
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    @PerApplication
    fun provideRxPreferences(context: Context): RxDataStore<Preferences> {
        return RxPreferenceDataStoreBuilder(context.applicationContext, "dataStoreAppRx").build()
    }

    @Provides
    @PerApplication
    fun provideDataStore(context: Context): DataStore<Preferences> {
        return context.applicationContext.dataStore
    }

    @Provides
    @PerApplication
    fun provideProtoDataStore(context: Context, serializer: UserPreferencesSerializer): DataStore<UserPreference> {
        return DataStoreFactory.create(
            serializer = serializer,
            produceFile = { context.dataStoreFile("newFile.pb") }
        )
    }

    @Provides
    @PerApplication
    fun provideSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PreferenceKeys.SharedPreferences.Name, Context.MODE_PRIVATE)
    }

    @PerApplication
    @Provides
    fun provideAead(context: Context): Aead {
        AeadConfig.register()
        return AndroidKeysetManager.Builder()
            .withSharedPref(context, KEYSET_NAME, PREFERENCE_FILE)
            .withKeyTemplate(AesGcmKeyManager.aes256GcmTemplate())
            .withMasterKeyUri(MASTER_KEY_URI)
            .build()
            .keysetHandle
            .getPrimitive(Aead::class.java)
    }

    @PerApplication
    @Provides
    fun provideSerialization(aead: Aead): UserPreferencesSerializer {
        return UserPreferencesSerializer(aead)
    }

}