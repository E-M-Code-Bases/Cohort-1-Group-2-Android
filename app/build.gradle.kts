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


    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
    implementation ("androidx.core:core-ktx:1.6.0")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.0")

    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")

    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.5")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")

    implementation("io.insert-koin:koin-android:3.1.2")
    implementation("io.insert-koin:koin-androidx-viewmodel:3.1.2")
    implementation ("io.insert-koin:koin-core:3.3.2")


    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")

//    implementation("io.reactivex.rxjava3:rxjava:3.0.0")
//    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")

    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("androidx.fragment:fragment-ktx:1.3.6")

    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")

//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
//    implementation ("io.insert-koin:koin-core:3.3.2")
//    implementation ("io.insert-koin:koin-android:3.3.2")
//    implementation ("io.insert-koin:koin-androidx-viewmodel:3.3.2")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
//    implementation("org.koin:koin-android:3.1.2")
//    implementation("org.koin:koin-androidx-viewmodel:3.1.2")
//    implementation("com.squareup.picasso:picasso:2.71828")
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
//    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
//    implementation("com.google.android.material:material:1.4.0")
//    implementation("androidx.viewpager2:viewpager2:1.0.0")
//    implementation("androidx.fragment:fragment-ktx:1.3.6")
//    implementation ("com.github.bumptech.glide:glide:4.12.0")
//    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")

//    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
//    implementation ("androidx.core:core-ktx:1.6.0")
//    implementation ("androidx.appcompat:appcompat:1.3.1")
//    implementation ("com.google.android.material:material:1.4.0")
//    implementation ("androidx.constraintlayout:constraintlayout:2.1.0")

//    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.5")
//    implementation ("androidx.navigation:navigation-ui-ktx:2.3.5")


}