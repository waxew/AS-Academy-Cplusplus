// پروژه 1: ماشین حساب خط فرمان با validation پایه.
#include <iostream>

int main() {
    double a{}, b{};
    char op{};
    std::cout << "Expression (example: 10 + 2): ";
    if (!(std::cin >> a >> op >> b)) {
        std::cerr << "Invalid input\n";
        return 1;
    }

    switch (op) {
        case '+': std::cout << a + b << '\n'; break;
        case '-': std::cout << a - b << '\n'; break;
        case '*': std::cout << a * b << '\n'; break;
        case '/':
            if (b == 0) {
                std::cerr << "Division by zero\n";
                return 2;
            }
            std::cout << a / b << '\n';
            break;
        default:
            std::cerr << "Unknown operator\n";
            return 3;
    }
    return 0;
}
