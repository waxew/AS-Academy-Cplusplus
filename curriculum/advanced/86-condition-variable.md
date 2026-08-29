# 86 — condition_variable

Condition variable اجازه می‌دهد thread تا برقرارشدن condition بخوابد، به جای busy waiting.

همیشه predicate را بررسی کنید چون wakeup می‌تواند spurious باشد.
