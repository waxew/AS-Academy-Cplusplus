// ورودی و خروجی پایه با cin/cout.
#include <iostream>
#include <string>

int main() {
    std::string name;
    int age{}; // مقداردهی صفر برای جلوگیری از مقدار نامشخص.

    std::cout << "Name: ";
    std::getline(std::cin, name); // کل خط، شامل فاصله‌ها، خوانده می‌شود.

    std::cout << "Age: ";
    std::cin >> age;

    std::cout << "Hello " << name << ", next year you will be " << age + 1 << ".\n";
    return 0;
}
