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
        versionCode = 11
        versionName = "2.9.0"
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

    // The app ships one compiled offline bundle generated exclusively from MainCourse.
    sourceSets {
        getByName("main").assets.srcDir(file("$buildDir/generated/courseAssets"))
    }
}

val mainCoursePackage = rootProject.file("as-academy-maincourse/courses/cplusplus/course")
val generatedCourseAssets = layout.buildDirectory.dir("generated/courseAssets/course/cpp")
val generatedBundle = generatedCourseAssets.map { it.file("bundle.json") }

// Fail fast: after migration the local course/cpp directory is never a content source again.
val verifyMainCourse = tasks.register("verifyMainCourse") {
    doLast {
        require(mainCoursePackage.resolve("manifest.json").isFile) {
            "C++ MainCourse package is missing. Initialize the as-academy-maincourse submodule."
        }
    }
}

// Core's official compiler reads the editable MainCourse directory, validates it and emits bundle.json.
val compileMainCourse = tasks.register<JavaExec>("compileMainCourse") {
    dependsOn(verifyMainCourse, ":tools:classes")
    classpath = project(":tools").extensions.getByType<org.gradle.api.tasks.SourceSetContainer>()["main"].runtimeClasspath
    mainClass.set("com.asdevelopers.academy.tools.CourseCompilerCliKt")
    args("compile", mainCoursePackage.absolutePath, generatedBundle.get().asFile.absolutePath)
    outputs.file(generatedBundle)
}

tasks.named("preBuild").configure { dependsOn(compileMainCourse) }

dependencies {
    implementation(project(":core"))
    implementation(project(":course"))
    implementation(project(":main-ui"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.navigation.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
}
