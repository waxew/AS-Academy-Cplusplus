// std::array و std::string برای داده‌های با اندازه ثابت و متن.
#include <array>
#include <iostream>
#include <string>

int main() {
    std::array<int, 5> scores{10, 12, 14, 16, 18};
    int sum{};
    for (const int score : scores) {
        sum += score;
    }

    std::string language = "C++";
    std::cout << language << " average=" << static_cast<double>(sum) / scores.size() << '\n';
    return 0;
}
