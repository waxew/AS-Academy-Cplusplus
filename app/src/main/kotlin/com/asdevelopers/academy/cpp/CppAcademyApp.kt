package com.asdevelopers.academy.cpp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.asdevelopers.academy.core.content.AssetCoursePackageSource
import com.asdevelopers.academy.core.content.CourseLoadResult
import com.asdevelopers.academy.core.content.CoursePackageLoader
import com.asdevelopers.academy.core.navigation.AcademyNavHost
import com.asdevelopers.academy.core.navigation.openExercise
import com.asdevelopers.academy.core.navigation.openLearningCatalog
import com.asdevelopers.academy.core.navigation.openLesson
import com.asdevelopers.academy.core.navigation.openProject
import com.asdevelopers.academy.core.navigation.openQuiz
import com.asdevelopers.academy.core.ui.screens.AcademyExerciseScreen
import com.asdevelopers.academy.core.ui.screens.AcademyProjectScreen
import com.asdevelopers.academy.core.ui.screens.AcademyQuizScreen
import com.asdevelopers.academy.mainui.AcademyCourseHomeScreen
import com.asdevelopers.academy.mainui.AcademyCourseLearningCatalog
import com.asdevelopers.academy.mainui.AcademyLessonReaderScreen
import com.asdevelopers.academy.mainui.AcademyMainUiLoading
import com.asdevelopers.academy.mainui.AcademyMainUiMessage
import com.asdevelopers.academy.mainui.AcademyMainUiTheme

/**
 * End-to-end C++ host.
 * The generated `course/cpp/bundle.json` is compiled from MainCourse during Gradle preBuild.
 */
@Composable
fun CppAcademyApp() {
    val context = LocalContext.current
    val navController = rememberNavController()
    var result by remember { mutableStateOf<CourseLoadResult?>(null) }

    LaunchedEffect(Unit) {
        result = CoursePackageLoader().load(
            AssetCoursePackageSource(context, "course/cpp/bundle.json")
        )
    }

    when (val state = result) {
        null -> AcademyMainUiLoading()
        is CourseLoadResult.Failure -> AcademyMainUiMessage(state.message)
        is CourseLoadResult.Invalid -> AcademyMainUiMessage(
            "محتوای C++ معتبر نیست:\n${state.errors.joinToString("\n")}"
        )
        is CourseLoadResult.Success -> {
            val bundle = state.bundle
            AcademyMainUiTheme(branding = bundle.branding, darkTheme = false) {
                AcademyNavHost(
                    navController = navController,
                    home = {
                        AcademyCourseHomeScreen(
                            bundle = bundle,
                            onOpenLesson = navController::openLesson,
                            onOpenLearningCatalog = navController::openLearningCatalog
                        )
                    },
                    settings = { AcademyMainUiMessage("تنظیمات مشترک از MainUi/Core فعال می‌شود.") },
                    about = { AcademyMainUiMessage("AS Academy C++ — محتوای آموزشی از MainCourse") },
                    lesson = { lessonId ->
                        val lesson = bundle.lessons.firstOrNull { it.id == lessonId }
                        if (lesson == null) {
                            AcademyMainUiMessage("درس پیدا نشد.")
                        } else {
                            AcademyLessonReaderScreen(
                                lesson = lesson,
                                onExerciseClick = navController::openExercise,
                                onQuizClick = navController::openQuiz,
                                onProjectClick = navController::openProject
                            )
                        }
                    },
                    quiz = { quizId ->
                        val quiz = bundle.quizzes.firstOrNull { it.id == quizId }
                        if (quiz == null) AcademyMainUiMessage("آزمون پیدا نشد.")
                        else AcademyQuizScreen(quiz = quiz, modifier = Modifier.fillMaxSize())
                    },
                    exercise = { exerciseId ->
                        val exercise = bundle.exercises.firstOrNull { it.id == exerciseId }
                        if (exercise == null) AcademyMainUiMessage("تمرین پیدا نشد.")
                        else AcademyExerciseScreen(exercise = exercise, modifier = Modifier.fillMaxSize())
                    },
                    project = { projectId ->
                        val project = bundle.projects.firstOrNull { it.id == projectId }
                        if (project == null) AcademyMainUiMessage("پروژه پیدا نشد.")
                        else AcademyProjectScreen(project = project, modifier = Modifier.fillMaxSize())
                    },
                    learningCatalog = {
                        AcademyCourseLearningCatalog(
                            bundle = bundle,
                            onQuizClick = navController::openQuiz,
                            onExerciseClick = navController::openExercise,
                            onProjectClick = navController::openProject
                        )
                    }
                )
            }
        }
    }
}
