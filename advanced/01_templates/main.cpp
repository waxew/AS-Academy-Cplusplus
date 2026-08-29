// Function template و concept در C++20.
#include <concepts>
#include <iostream>

template <std::totally_ordered T>
const T& maximum(const T& a, const T& b) {
    return (a < b) ? b : a;
}

int main() {
    std::cout << maximum(10, 20) << '\n';
    std::cout << maximum(2.5, 1.1) << '\n';
    return 0;
}
