// پروژه 3: Library Manager؛ نمونه OOP و جستجو.
#include <iostream>
#include <optional>
#include <string>
#include <vector>

class Library {
public:
    void add(std::string title) {
        books_.push_back(std::move(title));
    }

    std::optional<std::size_t> find(const std::string& title) const {
        for (std::size_t i = 0; i < books_.size(); ++i) {
            if (books_[i] == title) return i;
        }
        return std::nullopt;
    }

    void print() const {
        for (const auto& book : books_) std::cout << "- " << book << '\n';
    }

private:
    std::vector<std::string> books_;
};

int main() {
    Library library;
    library.add("The C++ Programming Language");
    library.add("Effective Modern C++");
    library.print();
    std::cout << (library.find("Effective Modern C++") ? "found\n" : "not found\n");
    return 0;
}
