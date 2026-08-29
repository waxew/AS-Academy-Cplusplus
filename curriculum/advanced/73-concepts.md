# 73 — Concepts

Concept در C++20 constraint مورد انتظار template را صریح می‌کند.

```cpp
template <std::integral T>
T twice(T value) { return value * 2; }
```

خطاهای template با concept معمولاً قابل فهم‌تر می‌شوند.
