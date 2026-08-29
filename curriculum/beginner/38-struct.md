# 38 — struct

`struct` برای مدل‌سازی داده ساده بسیار مناسب است.

```cpp
struct Product {
    int id{};
    std::string name;
    double price{};
};
```

در C++ تفاوت اصلی پیش‌فرض `struct` و `class` در access level است.
