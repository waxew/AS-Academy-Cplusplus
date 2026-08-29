# 63 — File Output

```cpp
std::ofstream out{"data.txt"};
if (!out) return 1;
out << "hello\n";
```

Stream فایل RAII است و هنگام پایان lifetime بسته می‌شود.
