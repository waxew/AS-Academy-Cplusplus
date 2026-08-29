# نصب و آماده‌سازی C++

## Windows
پیشنهاد اصلی: Visual Studio 2022 با workload گزینه Desktop development with C++؛ یا VS Code به همراه MSVC/MinGW و CMake.

بررسی Compiler:
```bash
g++ --version
```
یا:
```powershell
cl
```

## Linux
```bash
sudo apt update
sudo apt install build-essential cmake gdb
```

## macOS
```bash
xcode-select --install
brew install cmake
```

## Build کل مخزن
```bash
cmake -S . -B build
cmake --build build
ctest --test-dir build --output-on-failure
```
