# 51 — Static Member

Static member متعلق به class است نه هر object منفرد.

```cpp
class IdGenerator {
public:
    static int next();
};
```

از global state پنهان در static memberها باید با احتیاط استفاده کرد.
