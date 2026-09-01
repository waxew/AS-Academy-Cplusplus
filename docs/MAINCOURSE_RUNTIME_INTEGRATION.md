# C++ MainCourse runtime integration

C++ content is now consumed through one production path:

`AS-Academy-MainCourse/courses/cplusplus/course` -> Core CourseCompiler -> `course/cpp/bundle.json` Android asset -> Core CoursePackageLoader/Validator -> MainUi home/catalog/lesson reader -> C++ app.

The legacy local `course/cpp` directory is not referenced by the Android build. It remains only as a migration snapshot until repository cleanup.

Every lesson button on the shared MainUi home opens the matching lesson by stable ID. Lesson blocks are rendered by the shared renderer, while quiz/exercise/project actions route through Core navigation and shared screens.
