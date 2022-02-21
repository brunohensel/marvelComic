plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
}

android {
  compileSdk = 31

  defaultConfig {
    minSdk = 21
    targetSdk = 31
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }
  viewBinding {
    isEnabled = true
  }
}

dependencies {

  api(project(":characters:characters-api"))
  api(project(":archcomponents"))
  implementation(libs.androix.constraintLayout)
  implementation(libs.androix.core)
}