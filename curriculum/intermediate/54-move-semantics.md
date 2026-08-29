# 54 — Move Semantics

Move به‌جای duplicate کردن resource، ownership آن را منتقل می‌کند.

```cpp
std::string a{"hello"};
std::string b{std::move(a)};
```

پس از move، object مبدأ معتبر است ولی مقدار آن unspecified است.
