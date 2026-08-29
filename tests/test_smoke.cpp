// Smoke test بدون dependency خارجی؛ CI با exit code نتیجه را می‌فهمد.
#include <iostream>

constexpr int square(int value) {
    return value * value;
}

int main() {
    static_assert(square(4) == 16);
    if (square(5) != 25) {
        std::cerr << "Smoke test failed\n";
        return 1;
    }
    std::cout << "Smoke test passed\n";
    return 0;
}
