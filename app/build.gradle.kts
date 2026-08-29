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
        versionCode = 4
        versionName = "2.1.1"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // اطلاعات Signing هرگز داخل Git ذخیره نمی‌شود و فقط از Environment/Secrets خوانده می‌شود.
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

    // AGP 9 اجازه اضافه‌کردن Provider مستقیم به SourceSet را نمی‌دهد.
    // مسیر generated به‌صورت File ثابت معرفی می‌شود و task زیر قبل از Build آن را پر می‌کند.
    sourceSets {
        getByName("main").assets.srcDir(file("$buildDir/generated/courseAssets"))
    }
}

// Course Package اصلی در ریشه ریپو نگهداری می‌شود.
// قبل از Build همان منبع به assets تولیدی اپ Sync می‌شود تا محتوا duplicate نشود.
val syncCourseAssets = tasks.register<Sync>("syncCourseAssets") {
    from(rootProject.file("course/cpp"))
    into(file("$buildDir/generated/courseAssets/course/cpp"))
}

tasks.named("preBuild").configure {
    dependsOn(syncCourseAssets)
}

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
