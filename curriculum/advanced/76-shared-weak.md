# 76 — shared_ptr و weak_ptr

`shared_ptr` مالکیت مشترک دارد. `weak_ptr` observer غیرمالک است.

Shared ownership را فقط زمانی استفاده کنید که واقعاً چند owner مستقل لازم است؛ reference counting رایگان نیست.
