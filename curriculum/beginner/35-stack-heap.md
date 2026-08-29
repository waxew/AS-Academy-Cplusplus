# 35 — Stack و Heap

Objectهای local معمولاً lifetime خودکار دارند. Dynamic allocation نیازمند مدیریت مالکیت است.

```cpp
int local{10};
auto dynamic = std::make_unique<int>(20);
```

هدف اصلی یادگیری این فصل درک lifetime است، نه حفظ‌کردن محل دقیق فیزیکی حافظه.
