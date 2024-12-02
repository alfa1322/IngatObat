// Project-level build.gradle file

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:8.0.0' // Pastikan untuk menggunakan versi terbaru
        classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10' // Kotlin plugin jika proyek menggunakan Kotlin
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
