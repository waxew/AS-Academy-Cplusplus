# 36 — new و delete

```cpp
int* value = new int{42};
delete value;
value = nullptr;
```

این syntax مهم است چون در کد قدیمی دیده می‌شود، اما در Modern C++ مالکیت مستقیم با `new/delete` باید حداقل باشد.

## تمرین
یک مثال قدیمی با new/delete را به unique_ptr تبدیل کنید.
