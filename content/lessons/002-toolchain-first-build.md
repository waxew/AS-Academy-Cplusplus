# نصب ابزار و اولین Build

برای برنامه‌نویسی C++ به Compiler، Linker و معمولاً Debugger نیاز داریم. IDE الزامی نیست؛ فقط کار را ساده‌تر می‌کند.

## Windows
Visual Studio با workload مربوط به Desktop development with C++ انتخاب ساده‌ای است. VS Code هم در کنار MSVC یا MinGW قابل استفاده است.

## Linux
`g++`, `cmake` و `gdb` ابزارهای پایه هستند.

## macOS
Clang از طریق Command Line Tools در دسترس قرار می‌گیرد.

## اولین برنامه
```cpp
#include <iostream>

int main() {
    std::cout << "Hello C++\n";
    return 0;
}
```

## کامپایل مستقیم
```bash
g++ -std=c++20 main.cpp -o app
```

## با CMake
```bash
cmake -S . -B build
cmake --build build
```

نکته: خطای Compiler با خطای Linker یکی نیست. Compiler روی ترجمه کد تمرکز دارد؛ Linker نمادهای تولیدشده توسط واحدهای مختلف را به هم متصل می‌کند.
