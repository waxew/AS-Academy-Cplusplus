# 15 — تبدیل نوع

تبدیل implicit همیشه مطلوب نیست. برای تبدیل صریح از castهای C++ استفاده کنید.

```cpp
double average = static_cast<double>(sum) / count;
```

## تمرین
میانگین چند integer را بدون integer division محاسبه کنید.
