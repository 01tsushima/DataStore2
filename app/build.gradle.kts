import org.gradle.api.JavaVersion.VERSION_1_8
import Versions.navigation
import com.google.protobuf.gradle.*

plugins {
    id("com.android.application")
    id("kotlin-kapt")
    id("kotlin-android")
    id("com.google.protobuf") version "0.8.17"
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.datastore.test"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = VERSION_1_8
        targetCompatibility = VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = VERSION_1_8.toString()
    }
}
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.14.0"
    }

    // Generates the java Protobuf-lite code for the Protobufs in this project. See
    // https://github.com/google/protobuf-gradle-plugin#customizing-protobuf-compilation
    // for more information.
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}

dependencies {


    // Google
    implementation("com.google.android.material:material:1.4.0-rc01")

    implementation("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")

    // AndroidX
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.activity:activity-ktx:1.3.1")
    implementation("androidx.fragment:fragment-ktx:1.3.6")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")

    // Navigation
    implementation("androidx.navigation:navigation-ui-ktx:$navigation")
    implementation("androidx.navigation:navigation-runtime-ktx:$navigation")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigation")
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.4.6")

    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("androidx.datastore:datastore-preferences-rxjava2:1.0.0")

    implementation("com.google.dagger:dagger:2.39.1")
    kapt("com.google.dagger:dagger-compiler:2.39.1")

    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.0-beta01")

    implementation("ru.surfstudio.android:easyadapter:7.0.1")

    //proto buff
    implementation("androidx.datastore:datastore-core:1.0.0")
    implementation("com.google.protobuf:protobuf-javalite:3.18.0")


    implementation("com.google.crypto.tink:tink-android:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.2.2")
}