// binary_search و transform از کتابخانه algorithms.
#include <algorithm>
#include <iostream>
#include <vector>

int main() {
    std::vector<int> values{1, 2, 3, 4, 5};
    std::vector<int> squares(values.size());

    std::transform(values.begin(), values.end(), squares.begin(), [](int value) {
        return value * value;
    });

    std::cout << std::boolalpha << std::binary_search(values.begin(), values.end(), 4) << '\n';
    for (const int value : squares) {
        std::cout << value << ' ';
    }
    std::cout << '\n';
    return 0;
}
