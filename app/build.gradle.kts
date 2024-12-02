// App-level build.gradle file

plugins {
    id 'com.android.application'
    id 'kotlin-android' // Jika Anda menggunakan Kotlin, biarkan; hapus jika tidak
}

android {
    compileSdk 34 // Sesuaikan dengan versi compile SDK yang Anda gunakan

    defaultConfig {
        applicationId "com.example.medicationreminder" // Ganti dengan ID aplikasi Anda
        minSdk 21 // Minimum SDK yang didukung
        targetSdk 34 // Target SDK
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_11 // Menentukan versi Java yang digunakan
                targetCompatibility JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "1.8" // Jika menggunakan Kotlin
    }
}

dependencies {
    // AndroidX Libraries
    implementation 'androidx.core:core-ktx:1.9.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.activity:activity-ktx:1.7.2'

    // Room Database
    implementation 'androidx.room:room-runtime:2.5.0'
    kapt 'androidx.room:room-compiler:2.5.0' // Ganti annotationProcessor dengan kapt jika menggunakan Kotlin
    // Jika Anda tidak menggunakan Kotlin, gunakan annotationProcessor seperti berikut:
    // annotationProcessor 'androidx.room:room-compiler:2.5.0'

    // Testing Dependencies
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    // Firebase Cloud Messaging (Jika menggunakan Firebase untuk push notifications)
    implementation 'com.google.firebase:firebase-messaging:23.2.0'

    // Glide for Image Loading
    implementation 'com.github.bumptech.glide:glide:4.15.0'

    // Retrofit for Networking
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
}

// Apply Firebase plugin
apply plugin: 'com.google.gms.google-services' // Pastikan file google-services.json sudah ada di direktori app/

// Tambahkan baris ini jika Anda menggunakan Kotlin dan Room untuk annotation processing
apply plugin: 'kotlin-kapt' // Ini diperlukan untuk Room di Kotlin
