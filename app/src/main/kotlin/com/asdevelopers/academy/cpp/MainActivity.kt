package com.asdevelopers.academy.cpp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

/**
 * Thin Android entry point for the C++ Academy app.
 * Curriculum comes from MainCourse, rendering from MainUi and runtime/navigation from Core.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CppAcademyApp() }
    }
}
