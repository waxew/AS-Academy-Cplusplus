// نمایش ownership با unique_ptr/shared_ptr/weak_ptr.
#include <iostream>
#include <memory>

int main() {
    auto unique = std::make_unique<int>(42);
    auto shared = std::make_shared<int>(100);
    std::weak_ptr<int> observer = shared;

    std::cout << *unique << '\n';
    if (auto locked = observer.lock()) {
        std::cout << *locked << " owners=" << locked.use_count() << '\n';
    }
    return 0;
}
