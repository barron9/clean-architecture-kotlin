plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
}
android {
    compileSdkVersion(31)

    defaultConfig {
        applicationId ("com.example.androidview")
        minSdkVersion(16)
        targetSdkVersion(31)
        versionCode(1)
        versionName ("1.0")
        multiDexEnabled=true

        testInstrumentationRunner ("androidx.test.runner.AndroidJUnitRunner")
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


/*  buildTypes {
        release {
            minifyEnabled (false)
            proguardFiles getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }*//*

    buildToolsVersion ("30.0.2")
}*/


androidUIDep()

