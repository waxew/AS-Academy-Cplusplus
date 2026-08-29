# 61 — Lambda

Lambda یک callable محلی است.

```cpp
auto square = [](int x) { return x * x; };
```

Capture list تعیین می‌کند lambda به چه متغیرهای بیرونی و با چه semantics دسترسی دارد.
