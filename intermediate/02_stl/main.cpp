// ترکیب vector، algorithm و lambda.
#include <algorithm>
#include <iostream>
#include <vector>

int main() {
    std::vector<int> values{5, 1, 9, 2, 8, 3};
    std::sort(values.begin(), values.end());

    const auto evenCount = std::count_if(values.begin(), values.end(), [](int value) {
        return value % 2 == 0;
    });

    for (const int value : values) {
        std::cout << value << ' ';
    }
    std::cout << "\neven=" << evenCount << '\n';
    return 0;
}
