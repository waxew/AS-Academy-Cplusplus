// توابع، پارامتر const reference و overload.
#include <iostream>
#include <string>

int add(int a, int b) {
    return a + b;
}

double add(double a, double b) {
    return a + b;
}

void greet(const std::string& name) {
    // const reference از copy غیرضروری جلوگیری می‌کند و اجازه تغییر ورودی را نمی‌دهد.
    std::cout << "Hello " << name << '\n';
}

int main() {
    greet("AS Academy");
    std::cout << add(2, 3) << '\n';
    std::cout << add(2.5, 3.1) << '\n';
    return 0;
}
