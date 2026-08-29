# 44 — Constructor

Constructor invariant اولیه object را برقرار می‌کند.

```cpp
class User {
public:
    explicit User(std::string name) : name_(std::move(name)) {}
private:
    std::string name_;
};
```

`explicit` از conversion ناخواسته constructor تک‌پارامتری جلوگیری می‌کند.
