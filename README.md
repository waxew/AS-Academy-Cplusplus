# AS Academy — C++

دوره جامع C++ از صفر مطلق تا توسعه حرفه‌ای، پروژه‌محور و سازگار با معماری مشترک `AS-Academy-Core`.

## وضعیت
نسخه دوره: **1.0.0**  
Course ID: `cpp`  
استاندارد اصلی مثال‌ها: **C++20**  
Core contract: `contentSchemaVersion = 1`

## مسیر یادگیری
1. `fundamentals/` — نصب، Hello World، انواع داده و I/O
2. `beginner/` — شرط، حلقه، تابع، array/string، pointer/reference
3. `intermediate/` — OOP، STL، File I/O و exception
4. `advanced/` — template، RAII، smart pointer، thread و algorithms
5. `professional/` — CMake، network، database، Qt، performance، embedded، game و security
6. `projects/` — پروژه‌های مرحله‌ای و پروژه نهایی

نقشه کامل: [COURSE_MAP.md](COURSE_MAP.md)

## Build همه مثال‌ها
```bash
cmake -S . -B build
cmake --build build --config Release
ctest --test-dir build -C Release --output-on-failure
```

## وابستگی به Core
این ریپو منطق مشترک UI/Navigation/Progress/Quiz/Search/Bookmark/Settings/Database/Updater را تکرار نمی‌کند. این موارد در `AS-Academy-Core` نگهداری می‌شوند. جزئیات: [CORE_INTEGRATION.md](CORE_INTEGRATION.md).

## محتوای دوره
هر سطح شامل آموزش مفهومی، مثال قابل Build، تمرین و پروژه است. فایل‌های نمونه برای قابل فهم بودن سورس دارای کامنت توضیحی هستند.

## پروژه نهایی
`AS Store Manager`: نرم‌افزار مدیریت فروشگاه با C++20، Qt، SQLite، CMake، تست و معماری چندلایه. مشخصات در `docs/FINAL_PROJECT.md` و `projects/final_store_manager/README.md` آمده است.

## ساختار
```text
manifest.json
content/
fundamentals/
beginner/
intermediate/
advanced/
professional/
exercises/
projects/
tests/
docs/
.github/workflows/
```

## Build Quality
CI روی Windows، Linux و macOS پروژه را Configure، Build و Test می‌کند.

---
AS Academy / C++ Course Package
