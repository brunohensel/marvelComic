import java.io.FileInputStream
import java.util.Properties

val marvelKeysFile = rootProject.file("marvelkey.properties")
val marvelKeysProperties = Properties()
marvelKeysProperties.load(FileInputStream(marvelKeysFile))

plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("kotlin-kapt")
}

android {
  compileSdk = 31

  defaultConfig {
    applicationId = "com.brunohensel.marvelcomic"
    minSdk = 21
    targetSdk = 31
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation(project(":core:network"))
  implementation(project(":core:initializer"))
  implementation(project(":core:logger"))
  implementation(project(":utils"))
  implementation(project(":characters:characters-api"))
  implementation(project(":characters:characters-impl"))
  implementation(project(":characters:characters-ui"))
  implementation(libs.androix.core)
  implementation(libs.androix.appcompat)
  implementation(libs.material)
  implementation(libs.androix.constraintLayout)
  implementation(libs.dagger)
  kapt(libs.dagger.compiler)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androix.junit)
  androidTestImplementation(libs.androix.espresso)
}