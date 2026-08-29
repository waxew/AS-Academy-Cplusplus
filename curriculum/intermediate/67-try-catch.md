# 67 — try / catch

```cpp
try {
    run();
} catch (const std::exception& e) {
    std::cerr << e.what();
}
```

Catch را در سطحی قرار دهید که بتوان تصمیم معنی‌داری درباره خطا گرفت.
