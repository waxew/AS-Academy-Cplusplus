// رابطه object، reference و pointer.
#include <iostream>
#include <memory>

int main() {
    int value = 42;
    int& ref = value;     // reference نام دیگری برای همان object است.
    int* ptr = &value;    // pointer آدرس object را نگه می‌دارد.

    ref = 50;
    *ptr += 10;           // dereference و تغییر مقدار اصلی.

    // در کد مدرن به جای new/delete خام، مالکیت را با smart pointer بیان می‌کنیم.
    auto owned = std::make_unique<int>(100);

    std::cout << value << " | " << *owned << '\n';
    return 0;
}
