# CMake و معماری

مباحث: target-based CMake، libraryها، include visibility، FetchContent، presets، install/package، cross compilation و CI.

ساختار پروژه بزرگ:
```text
app/
include/
src/
tests/
cmake/
third_party/
CMakeLists.txt
```

اصل: وابستگی‌ها باید صریح، one-way و قابل تست باشند.
