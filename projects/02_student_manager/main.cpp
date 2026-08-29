// پروژه 2: مدل ساده مدیریت دانشجو با vector.
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

struct Student {
    int id{};
    std::string name;
    double score{};
};

int main() {
    std::vector<Student> students{{1, "Ali", 18.5}, {2, "Sara", 19.2}, {3, "Reza", 16.0}};

    std::sort(students.begin(), students.end(), [](const Student& a, const Student& b) {
        return a.score > b.score;
    });

    for (const Student& student : students) {
        std::cout << student.id << " | " << student.name << " | " << student.score << '\n';
    }
    return 0;
}
