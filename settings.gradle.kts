pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AS-Academy-Cplusplus"

include(":app", ":core", ":course", ":main-ui")

// Core owns runtime engines and Course contracts.
project(":core").projectDir = file("as-academy-core/core")
project(":course").projectDir = file("as-academy-core/course")

// MainUi owns the reusable presentation layer. Course apps must not fork shared screens.
project(":main-ui").projectDir = file("as-academy-mainui/main-ui")
