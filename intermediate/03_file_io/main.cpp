// نوشتن و خواندن فایل متنی با RAII.
#include <fstream>
#include <iostream>
#include <string>

int main() {
    {
        std::ofstream out("academy.txt");
        if (!out) {
            std::cerr << "Cannot open output file\n";
            return 1;
        }
        out << "C++ course\n";
    } // فایل اینجا خودکار بسته می‌شود.

    std::ifstream in("academy.txt");
    std::string line;
    if (std::getline(in, line)) {
        std::cout << line << '\n';
    }
    return 0;
}
