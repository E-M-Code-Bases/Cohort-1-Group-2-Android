plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.jemutai.androidapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jemutai.androidapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

<<<<<<< Updated upstream
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //implementation("io.insert-koin:koin-android:3.1.2")
    //implementation("io.insert-koin:koin-androidx-viewmodel:3.1.2")
   // implementation("io.insert-koin:koin-core:3.3.2")
    //implementation("io.insert-koin:koin-androidx:3.4.0")

    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3") // or the latest version
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3") // or the latest version


    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.0.0")
}
=======
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-android:1.2.1")
    implementation("androidx.compose.material3:material3-desktop:1.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
>>>>>>> Stashed changes
