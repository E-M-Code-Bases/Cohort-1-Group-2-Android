plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.movies_poa_app"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.movies_poa_app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.paging.common.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation (libs.kotlin.stdlib)
    implementation (libs.androidx.core.ktx.v160)
    implementation (libs.androidx.appcompat.v131)
    implementation (libs.material.v140)
    implementation (libs.androidx.constraintlayout.v210)

    implementation (libs.androidx.lifecycle.extensions)
    implementation (libs.androidx.lifecycle.viewmodel.ktx.v231)
    implementation (libs.androidx.lifecycle.livedata.ktx.v231)

    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)

    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

    implementation(libs.koin.android)
    implementation(libs.insert.koin.koin.androidx.viewmodel)
    implementation (libs.koin.core)
    implementation(libs.koin.androidx)


    implementation (libs.retrofit)
    implementation (libs.converter.moshi)
    implementation (libs.logging.interceptor)

    implementation (libs.material)
    implementation (libs.androidx.viewpager2)
    implementation (libs.androidx.fragment.ktx.v136)

    implementation(libs.picasso)

}