// شرط، switch و loop در یک مثال کوچک.
#include <iostream>

int main() {
    int number{};
    std::cin >> number;

    if (number > 0) {
        std::cout << "positive\n";
    } else if (number < 0) {
        std::cout << "negative\n";
    } else {
        std::cout << "zero\n";
    }

    for (int i = 1; i <= 5; ++i) {
        std::cout << i << (i == 5 ? '\n' : ' ');
    }

    switch (number % 2) {
        case 0: std::cout << "even\n"; break;
        default: std::cout << "odd\n"; break;
    }
    return 0;
}
