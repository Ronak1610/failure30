plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.failure30"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.failure30"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_19.toString()
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.compose.material)
    implementation(libs.compose.material.icons)
    //Navigation
    implementation(libs.navigation.compose)
    //Hilt Navigation Compose
    implementation(libs.hilt.navigation.compose)
    //Hilt
    implementation(libs.hilt)
    implementation(libs.material3.android)
    ksp(libs.hilt.compiler)
    //Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    //Serialization
    implementation(libs.serialization)
    implementation(platform(libs.compose.bom))



    androidTestImplementation(libs.navigation.testing)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.runner)
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.truth)
    debugImplementation(libs.ui.test.manifest)
}