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

include(":app", ":core", ":course")

// ماژول‌های مشترک مستقیماً از ریپوی مرکزی Core استفاده می‌شوند؛
// هیچ کد مشترکی در این ریپو کپی نمی‌شود.
project(":core").projectDir = file("as-academy-core/core")
project(":course").projectDir = file("as-academy-core/course")
