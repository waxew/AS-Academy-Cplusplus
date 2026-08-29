# 49 — Virtual Destructor

اگر object مشتق‌شده از طریق pointer به base حذف شود، destructor پایه باید virtual باشد.

```cpp
virtual ~Shape() = default;
```

این یکی از قواعد مهم طراحی hierarchy polymorphic است.
