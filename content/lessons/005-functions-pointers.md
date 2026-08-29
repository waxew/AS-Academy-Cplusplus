# توابع، Reference و Pointer

توابع برنامه را به واحدهای کوچک‌تر با مسئولیت مشخص تقسیم می‌کنند.

```cpp
int add(int a, int b) {
    return a + b;
}
```

## انتقال پارامتر
- by value: یک مقدار مستقل به تابع می‌رسد.
- by reference: تابع به همان object دسترسی دارد.
- `const T&`: برای objectهای بزرگ زمانی مناسب است که فقط خواندن لازم باشد.

## Pointer
Pointer آدرس object را نگه می‌دارد.
```cpp
int value{42};
int* ptr = &value;
std::cout << *ptr;
```

## خطرها
null dereference، dangling pointer و double delete. در کد مدرن، مالکیت معمولاً با `std::unique_ptr` و `std::shared_ptr` بیان می‌شود، نه با `new/delete` پراکنده.

## تمرین
تابعی بنویسید که یک `std::vector<int>` را با `const reference` بگیرد و میانگین را برگرداند.
