# 110 — Boost.Asio

Asio abstractionهای synchronous/asynchronous برای I/O فراهم می‌کند. `io_context` مرکز اجرای handlerهاست.

در async design، lifetime objectهایی که callback به آن‌ها دسترسی دارد باید دقیق مدیریت شود.
