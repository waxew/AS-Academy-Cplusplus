# 33 — nullptr

Pointer ممکن است به هیچ object معتبری اشاره نکند.

```cpp
int* ptr{nullptr};
if (ptr) {
    std::cout << *ptr;
}
```

Dereference کردن nullptr خطای جدی runtime و undefined behavior است.
