# 43 — Class و Object

Class blueprint یک نوع است و object نمونه‌ای از آن.

```cpp
class Counter {
public:
    void increment() { ++value_; }
    int value() const { return value_; }
private:
    int value_{};
};
```
