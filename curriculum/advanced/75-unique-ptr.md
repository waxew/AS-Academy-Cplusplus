# 75 — unique_ptr

`std::unique_ptr` مالکیت یکتا را مدل می‌کند.

```cpp
auto p = std::make_unique<Product>();
```

قابل copy نیست و ownership با move منتقل می‌شود.
