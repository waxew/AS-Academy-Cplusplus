# AS Academy C++ — Architecture 2.8

The C++ application is now a thin Course App in the four-repository Academy architecture.

- `AS-Academy-Core`: runtime engines, navigation contracts, persistence, progress, search, quiz/exercise/project engines and Course schema.
- `AS-Academy-MainUi`: shared Compose presentation layer, screens, shell, drawer/profile and design system.
- `AS-Academy-MainCourse`: canonical curriculum packages. C++ lives at `courses/cplusplus/course` after bootstrap migration.
- `AS-Academy-Cplusplus`: application ID, version, C++ branding/capabilities, platform wrapper and release configuration only.

## Migration safety

Version 2.8.0 pins Core, MainUi and MainCourse as submodules. During the bootstrap window the Gradle asset sync prefers MainCourse and falls back to the legacy local `course/cpp` package only when the pinned MainCourse commit predates the C++ migration. The fallback must be removed after the MainCourse migration is verified and the submodule is advanced.

All new educational edits must be made in MainCourse first. Shared UI edits must be made in MainUi. Shared runtime behavior must be made in Core.
