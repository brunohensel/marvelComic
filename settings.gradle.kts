pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}
rootProject.name = "MarvelComic"
include(":app")
include(":core:network")
include(":core:initializer")
include(":core:logger")
include(":utils")
include(":characters:characters-api")
include(":characters:characters-impl")
include(":characters:characters-ui")
include(":archcomponents")
include(":components:character")
