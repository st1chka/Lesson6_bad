package ex8;

class Manager extends Employee {

  @Override
  public void setSalary(double salary) {
    super.validateSalary(salary);
    if (salary < 5000) {
      throw new IllegalArgumentException("Manager salary too low");
    }
    this.salary = salary;
  }
}
