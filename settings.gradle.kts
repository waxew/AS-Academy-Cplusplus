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

include(":app", ":core", ":course", ":engine", ":tools", ":main-ui")

// Core owns runtime engines, Course contracts and the canonical Course compiler.
project(":core").projectDir = file("as-academy-core/core")
project(":course").projectDir = file("as-academy-core/course")
project(":engine").projectDir = file("as-academy-core/engine")
project(":tools").projectDir = file("as-academy-core/tools")

// MainUi owns all reusable presentation. The C++ app only wires content and branding.
project(":main-ui").projectDir = file("as-academy-mainui/main-ui")
