// Exception برای گزارش خطای قابل مدیریت.
#include <iostream>
#include <stdexcept>

int divide(int a, int b) {
    if (b == 0) {
        throw std::invalid_argument("division by zero");
    }
    return a / b;
}

int main() {
    try {
        std::cout << divide(10, 2) << '\n';
        std::cout << divide(10, 0) << '\n';
    } catch (const std::exception& error) {
        std::cerr << "Error: " << error.what() << '\n';
    }
    return 0;
}
