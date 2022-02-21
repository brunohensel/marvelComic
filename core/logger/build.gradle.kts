plugins {
  id("com.android.library")
  kotlin("android")
}

android {
  compileSdk = 31

  defaultConfig {
    minSdk = 21
    targetSdk = 31
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }
}

dependencies {
  implementation(project(":core:initializer"))
  implementation(libs.timber)
  implementation(libs.dagger)
}