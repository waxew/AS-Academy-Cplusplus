// نمونه انواع داده، const و auto.
#include <iostream>
#include <string>

int main() {
    int age = 25;                 // عدد صحیح.
    double score = 18.75;         // عدد اعشاری دقت دوگانه.
    bool active = true;           // مقدار منطقی.
    char grade = 'A';             // یک کاراکتر.
    std::string name = "Ali";     // رشته استاندارد C++.
    const double pi = 3.1415926;   // ثابت؛ بعداً قابل تغییر نیست.
    auto year = 2026;             // Compiler نوع int را استنتاج می‌کند.

    std::cout << name << " | " << age << " | " << score << " | "
              << active << " | " << grade << " | " << pi << " | " << year << '\n';
    return 0;
}
