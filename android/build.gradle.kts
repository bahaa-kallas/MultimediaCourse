plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    val activityVersion = "1.2.2"

    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.3.0-alpha03")
    implementation("androidx.activity:activity-ktx:$activityVersion")
}
