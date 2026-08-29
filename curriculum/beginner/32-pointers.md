# 32 — Pointer

Pointer آدرس یک object را ذخیره می‌کند.

```cpp
int value{42};
int* ptr{&value};
std::cout << *ptr;
```

`&` آدرس را می‌گیرد و `*` pointer را dereference می‌کند.

## تمرین
یک pointer به integer بسازید و مقدار را از طریق pointer تغییر دهید.
