# معماری حرفه‌ای پروژه C++

پروژه بزرگ نباید به مجموعه‌ای از فایل‌های بدون مرز تبدیل شود. dependency direction و ownership باید روشن باشند.

## ساختار پیشنهادی
- domain: مدل و قواعد کسب‌وکار
- application: use caseها
- infrastructure: database/network/filesystem
- ui: رابط کاربر

## CMake Target-Based
به جای تنظیم global flagها، dependency و optionها را روی targetها تعریف کنید.

## Quality Gates
- warningهای Compiler
- unit/integration test
- AddressSanitizer / UBSan
- static analysis
- Release build
- CI چندسیستمی

## اصل Core در AS Academy
Navigation، Progress، Quiz، Search و سایر قابلیت‌های مشترک در `AS-Academy-Core` باقی می‌مانند؛ Course repo نباید آن‌ها را duplicate کند.
