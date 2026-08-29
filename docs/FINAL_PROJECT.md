# پروژه نهایی — AS Store Manager

هدف: ساخت نرم‌افزار مدیریت فروشگاه دسکتاپ با معماری چندلایه.

## ماژول‌ها
- User/Profile
- Customer
- Product/Category
- Inventory
- Invoice
- Payment
- Reports
- Search
- Backup/Restore
- Settings

## فناوری‌ها
C++20، CMake، Qt، SQLite، STL، RAII، exceptions و testing.

## معماری
`ui -> application/services -> domain -> repository -> sqlite`

## معیار قبولی
- بدون memory leak شناخته‌شده
- مدیریت خطا و validation
- unit/integration tests برای منطق اصلی
- build در Release
- مستندات نصب و استفاده
- commit history قابل پیگیری
