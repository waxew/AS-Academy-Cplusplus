# Release Readiness — 2.2.0

## وضعیت فعلی
- Debug APK در CI با موفقیت Build شده است.
- Unit Testهای فعلی پاس شده‌اند.
- CI اکنون Release APK بدون امضا را نیز در هر Push می‌سازد.
- Workflow جداگانه Release برای امضای Production از GitHub Secrets آماده است.
- Signing key داخل repository نگهداری نمی‌شود.

## Secrets موردنیاز برای Publish Signed
- `AS_ACADEMY_KEYSTORE_BASE64`
- `AS_ACADEMY_KEYSTORE_PASSWORD`
- `AS_ACADEMY_KEY_ALIAS`
- `AS_ACADEMY_KEY_PASSWORD`

## Core
Submodule به نسخه جدید Core متصل شده تا قابلیت‌های مشترک جدید مانند Continue Learning و Learning Extras بدون duplicate شدن منطق در Course repo در اختیار اپ باشد.

## خروجی‌ها
- Debug APK: برای تست و توسعه
- Unsigned Release APK: برای اعتبارسنجی Release build
- Signed Release APK: پس از تنظیم Secrets
