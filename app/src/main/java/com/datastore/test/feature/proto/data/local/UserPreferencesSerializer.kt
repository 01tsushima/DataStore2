package com.datastore.test.feature.proto.data.local

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.datastore.test.UserPreference
import com.google.crypto.tink.Aead
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class UserPreferencesSerializer @Inject constructor(private val aead: Aead) : Serializer<UserPreference> {

    override val defaultValue: UserPreference = UserPreference.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreference {
        try {
            val encryptedInput = input.readBytes()

            val decryptedInput = if (encryptedInput.isNotEmpty()) {
                aead.decrypt(encryptedInput, null)
            } else {
                encryptedInput
            }
            return UserPreference.parseFrom(decryptedInput)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: UserPreference, output: OutputStream) {
        val encryptedBytes = aead.encrypt(t.toByteArray(), null)
        output.write(encryptedBytes)
    }
}