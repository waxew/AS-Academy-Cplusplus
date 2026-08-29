# 34 — Pointer Arithmetic

Pointer arithmetic عمدتاً در محدوده یک array معنی‌دار است.

```cpp
int values[]{10,20,30};
int* p = values;
std::cout << *(p + 1);
```

در کد روزمره، iterator و containerهای STL معمولاً انتخاب امن‌تری هستند.
