# Tests

نسخه پایه از smoke test بدون dependency خارجی استفاده می‌کند تا کل مخزن در CI قابل Build باشد. در پروژه‌های تخصصی، GoogleTest/Catch2 می‌تواند به‌صورت target اختیاری اضافه شود.

اجرا:
```bash
cmake -S . -B build
cmake --build build
ctest --test-dir build --output-on-failure
```
