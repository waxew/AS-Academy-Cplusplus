// نمونه Encapsulation، constructor و polymorphism.
#include <iostream>
#include <memory>
#include <string>

class Person {
public:
    explicit Person(std::string name) : name_(std::move(name)) {}
    virtual ~Person() = default;
    virtual void describe() const { std::cout << "Person: " << name_ << '\n'; }
protected:
    std::string name_;
};

class Student final : public Person {
public:
    Student(std::string name, int level) : Person(std::move(name)), level_(level) {}
    void describe() const override {
        std::cout << "Student: " << name_ << ", level=" << level_ << '\n';
    }
private:
    int level_{};
};

int main() {
    std::unique_ptr<Person> person = std::make_unique<Student>("Sara", 3);
    person->describe();
    return 0;
}
