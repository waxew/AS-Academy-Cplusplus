# 83 — std::thread

```cpp
std::thread worker{[] { /* work */ }};
worker.join();
```

Thread باید پیش از destruction join یا detach شده باشد. طراحی ownership thread اهمیت زیادی دارد.
