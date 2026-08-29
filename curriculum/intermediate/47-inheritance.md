# 47 — Inheritance

Inheritance زمانی مناسب است که رابطه واقعی `is-a` وجود دارد.

```cpp
class Shape { ... };
class Circle : public Shape { ... };
```

برای reuse صرف، composition اغلب گزینه بهتری است.
