# 41 — Header و Source

Declaration معمولاً در header و definition در source قرار می‌گیرد.

```cpp
// math.hpp
int add(int a, int b);
```

```cpp
// math.cpp
int add(int a, int b) { return a + b; }
```

این جداسازی پروژه را modular می‌کند.
