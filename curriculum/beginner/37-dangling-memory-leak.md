# 37 — Dangling Pointer و Memory Leak

Dangling pointer به object پایان‌یافته اشاره می‌کند. Memory leak زمانی رخ می‌دهد که resource تخصیص‌یافته دیگر قابل آزادسازی نباشد.

## قاعده
Ownership را صریح طراحی کنید و RAII را ترجیح دهید.
