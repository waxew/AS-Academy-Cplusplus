# 79 — constexpr

`constexpr` امکان ارزیابی compile-time را در صورت فراهم بودن ورودی مناسب می‌دهد.

```cpp
constexpr int square(int x) { return x * x; }
static_assert(square(4) == 16);
```
