# Android App Stage — 2.1.0

در این مرحله ریپوی C++ از Course Package صرف به اپ اندرویدی قابل Build ارتقا پیدا کرده است.

## معماری
- `app/`: Wrapper اختصاصی C++
- `course/cpp/`: محتوای دوره
- `as-academy-core/`: Git submodule به ریپوی مرکزی Core
- `:core` و `:course`: مستقیماً از submodule استفاده می‌شوند

## رفتار اپ
`MainActivity` فقط `AcademyCourseApp("cpp")` را اجرا می‌کند. Core مسئول Home، Chapter، Lesson Renderer، Search، Bookmark، Progress، Settings و About است.

## Assets
در Build، `course/cpp` با task `syncCourseAssets` به `assets/course/cpp` منتقل می‌شود. بنابراین منبع واحد محتوا حفظ می‌شود.

## Code Runner
قابلیت Code Runner در 2.1.0 موقتاً false است، چون اجرای native C++ داخل Android هنوز Runner اختصاصی امن و قابل اتکایی ندارد. مثال‌های کد همچنان Render می‌شوند.

## Build
```bash
git submodule update --init --recursive
gradle :app:assembleDebug
```

CI نیز همین مسیر را اجرا و APK Debug را به‌عنوان artifact ذخیره می‌کند.
