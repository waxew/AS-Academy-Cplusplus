# 45 — Destructor

Destructor هنگام پایان lifetime اجرا می‌شود و پایه RAII است.

```cpp
~FileHandle() {
    // release resource
}
```

اگر memberها خودشان RAII باشند، اغلب destructor دستی نیاز نیست.
