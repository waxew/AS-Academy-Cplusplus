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
        versionCode = 3
        versionName = "2.1.0"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    sourceSets {
        getByName("main").assets.srcDir(layout.buildDirectory.dir("generated/courseAssets"))
    }
}

// Course Package اصلی در ریشه ریپو نگهداری می‌شود.
// پیش از Build، فقط همان بسته به assets اپ Sync می‌شود تا duplicate source نداشته باشیم.
val syncCourseAssets by tasks.registering(Sync::class) {
    from(rootProject.file("course/cpp"))
    into(layout.buildDirectory.dir("generated/courseAssets/course/cpp"))
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
