# 29 — Range-based for

```cpp
for (const int value : values) {
    std::cout << value;
}
```

برای objectهای بزرگ از `const auto&` استفاده کنید تا copy غیرضروری نداشته باشید.
