package ex8;

import lombok.Getter;

@Getter
abstract class Employee {

  protected int id;
  protected String name;
  protected int age;
  protected double salary;
  protected String email;

  // Общие методы валидации
  protected void validateSalary(double salary) {
    if (salary <= 0) {
      throw new IllegalArgumentException("Invalid salary");
    }
  }

  protected void validateAge(int age) {
    if (age <= 18 || age >= 65) {
      throw new IllegalArgumentException("Invalid age");
    }
  }

  public void setSalary(double salary) {
    validateSalary(salary);
    this.salary = salary;
  }

  public void setAge(int age) {
    validateAge(age);
    this.age = age;
  }

}
