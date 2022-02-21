import java.io.FileInputStream
import java.util.Properties

val marvelKeysFile = rootProject.file("marvelkey.properties")
val marvelKeysProperties = Properties()
marvelKeysProperties.load(FileInputStream(marvelKeysFile))

plugins {
  id("com.android.library")
  kotlin("android")
  id("kotlin-kapt")
}

android {
  compileSdk = 31

  defaultConfig {
    minSdk = 21
    targetSdk = 31
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    buildConfigField("String", "CONSUMER_KEY", marvelKeysProperties.getProperty("CONSUMER_KEY"))
    buildConfigField("String", "SECRETE_KEY", marvelKeysProperties.getProperty("SECRETE_KEY"))
  }
}

dependencies {
  implementation(project(":characters:characters-api"))
  api(libs.coroutines)
  implementation(libs.dagger)
  kapt(libs.dagger.compiler)
  api(libs.retrofit2)
  implementation(libs.retrofit2.gsonConverter)
  implementation(libs.okhttp3)
  implementation(libs.okhttp3.logInterceptor)
}