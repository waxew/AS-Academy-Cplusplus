# 64 — File Input

```cpp
std::ifstream in{"data.txt"};
std::string line;
while (std::getline(in, line)) { }
```

همیشه failure بازشدن فایل و format نامعتبر را در نظر بگیرید.
