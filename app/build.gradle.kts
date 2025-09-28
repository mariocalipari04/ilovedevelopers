import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.unimib.ilovedevelopers"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.unimib.ilovedevelopers"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        resValue("string", "jobapi_key", gradleLocalProperties(rootDir, providers).getProperty("jobapi_key"))
        resValue("string", "jobapi_id", gradleLocalProperties(rootDir, providers).getProperty("jobapi_id"))
        resValue("bool", "debug_mode", gradleLocalProperties(rootDir, providers).getProperty("debug_mode"))
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.retrofit)
    implementation("commons-validator:commons-validator:1.10.0")
    implementation("com.google.code.gson:gson:2.13.2")
    implementation("androidx.room:room-runtime:2.8.1")
    implementation(libs.logging.interceptor)
    implementation(libs.google.material)
    annotationProcessor(libs.room.compiler)
    implementation(libs.converter.gson)
    implementation(libs.retrofit)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}