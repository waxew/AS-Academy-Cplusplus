# 108 — TCP Socket عمیق‌تر

Socket endpoint ارتباط است. در TCP باید اتصال، read/write ناقص، disconnect و timeout مدیریت شوند.

## نکته
یک `send` لزوماً تمام buffer را ارسال نمی‌کند و یک `recv` لزوماً یک message کامل تحویل نمی‌دهد.
