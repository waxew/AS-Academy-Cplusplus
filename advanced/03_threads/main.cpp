// thread و mutex برای محافظت از داده مشترک.
#include <iostream>
#include <mutex>
#include <thread>
#include <vector>

int main() {
    std::mutex mutex;
    int counter{};

    auto work = [&]() {
        for (int i = 0; i < 1000; ++i) {
            std::lock_guard<std::mutex> lock(mutex);
            ++counter;
        }
    };

    std::vector<std::thread> threads;
    for (int i = 0; i < 4; ++i) {
        threads.emplace_back(work);
    }
    for (auto& thread : threads) {
        thread.join();
    }

    std::cout << counter << '\n';
    return 0;
}
