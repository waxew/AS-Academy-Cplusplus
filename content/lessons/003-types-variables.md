# متغیرها و انواع داده

یک متغیر نامی برای یک object در حافظه است. نوع آن تعیین می‌کند چه مجموعه‌ای از مقادیر و عملیات معتبر است.

## انواع پایه
`bool`, `char`, `short`, `int`, `long`, `long long`, `float`, `double`.

برای متن در اغلب برنامه‌ها از `std::string` استفاده می‌کنیم.

## Initialization
```cpp
int count{0};
double price{12.5};
const int maxUsers{100};
```

Brace initialization انتخاب امنی است چون بسیاری از narrowing conversionهای ناخواسته را رد می‌کند.

## auto
```cpp
auto year = 2026;
```
`auto` نوع را حذف نمی‌کند؛ Compiler آن را استنتاج می‌کند.

## Scope و Lifetime
Scope محل قابل دسترس بودن نام است. Lifetime مدت زنده‌بودن object است. این دو مفهوم مشابه‌اند اما یکسان نیستند.

## تمرین
برنامه‌ای بسازید که نام کالا، قیمت و تعداد را بگیرد و مبلغ کل را حساب کند.
