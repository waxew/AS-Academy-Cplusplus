# Multithreading و Concurrency

Threadها می‌توانند هم‌زمان روی داده‌های مشترک کار کنند. اگر دسترسی بدون synchronization باشد data race رخ می‌دهد و رفتار برنامه undefined است.

## mutex
```cpp
std::mutex m;
std::lock_guard<std::mutex> lock(m);
```
`lock_guard` با RAII آزادشدن lock را تضمین می‌کند.

## مشکلات کلاسیک
- race condition
- deadlock
- starvation
- false sharing

## ابزارها
ThreadSanitizer برای پیدا کردن بسیاری از data raceها مفید است.

## تمرین
یک producer/consumer queue با `std::mutex` و `std::condition_variable` طراحی کنید و شرط توقف مشخص داشته باشید.
