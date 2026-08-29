# Content Finalization — v2.4.0

این نسخه دو هدف را همزمان انجام می‌دهد: افزایش عمق آموزشی و سازگاری کامل runtime با AS-Academy-Core.

## اصلاح Contract
تمام Lesson Blockهای فعال اکنون `id`, `type`, `content` معتبر دارند؛ این دقیقاً همان ساختاری است که `AssetCoursePackageLoader` می‌خواند.

## عمق آموزشی
22 درس جامع داخل app package اکنون مباحث نقشه 127 micro-lesson را در بلوک‌های مفهومی، code، warning، exercise، diagram و project جمع‌بندی می‌کنند. Curriculum 127گانه همچنان برای ریزمسیر موضوعی حفظ شده است.

## ارزیابی
Quizهای درس‌محور، Mastery Quizهای سطحی، Exerciseهای کدنویسی، Specialist Labs و Capstone موجودند.

## باقی‌مانده خارج از Content
- QA روی emulator/device
- Signing Key واقعی و Publish signed APK
- C++ Code Runner فقط پس از انتخاب sandbox امن

Code Runner تا آن زمان عمداً false باقی می‌ماند.
