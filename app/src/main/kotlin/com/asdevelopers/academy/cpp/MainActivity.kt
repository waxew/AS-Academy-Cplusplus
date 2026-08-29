package com.asdevelopers.academy.cpp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.asdevelopers.academy.core.ui.AcademyCourseApp

/**
 * ورودی اختصاصی اپ آموزش C++.
 * تمام Navigation، Progress، Search، Bookmark، Settings و Renderer از AS-Academy-Core می‌آیند.
 * این Activity فقط Course ID اختصاصی C++ را به Core معرفی می‌کند.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AcademyCourseApp(courseId = "cpp")
        }
    }
}
