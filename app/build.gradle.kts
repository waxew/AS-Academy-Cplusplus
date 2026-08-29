plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.asdevelopers.academy.cpp"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.asdevelopers.academy.cpp"
        minSdk = 23
        targetSdk = 37
        versionCode = 6
        versionName = "2.4.0"
    }

    buildFeatures { compose = true }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    val releaseStorePath = System.getenv("AS_ACADEMY_KEYSTORE_PATH")
    if (!releaseStorePath.isNullOrBlank()) {
        signingConfigs {
            create("release") {
                storeFile = file(releaseStorePath)
                storePassword = System.getenv("AS_ACADEMY_KEYSTORE_PASSWORD")
                keyAlias = System.getenv("AS_ACADEMY_KEY_ALIAS")
                keyPassword = System.getenv("AS_ACADEMY_KEY_PASSWORD")
            }
        }
        buildTypes {
            getByName("release") {
                signingConfig = signingConfigs.getByName("release")
                isMinifyEnabled = false
            }
        }
    }

    sourceSets {
        getByName("main").assets.srcDir(file("$buildDir/generated/courseAssets"))
    }
}

val syncCourseAssets = tasks.register<Sync>("syncCourseAssets") {
    from(rootProject.file("course/cpp"))
    into(file("$buildDir/generated/courseAssets/course/cpp"))
}

tasks.named("preBuild").configure { dependsOn(syncCourseAssets) }

dependencies {
    implementation(project(":core"))
    implementation(project(":course"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
}
