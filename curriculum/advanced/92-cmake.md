# 92 — CMake

CMake یک build-system generator است.

```cmake
add_executable(app main.cpp)
target_compile_features(app PRIVATE cxx_std_20)
```

Target-based configuration وابستگی‌ها را شفاف‌تر از flagهای global نگه می‌دارد.
