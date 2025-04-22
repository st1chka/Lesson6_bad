package ex8;

import java.util.ArrayList;
import java.util.List;

class EmployeeManager {

  private List<Employee> employees = new ArrayList<>();
  private DatabaseConnection dbConnection;

  // Исправление DIP: внедрение зависимости через конструктор
  public EmployeeManager(DatabaseConnection dbConnection) {
    this.dbConnection = dbConnection;
  }

  // Упрощение сложной логики (KISS)
  public void processEmployeeData(Employee emp) {
    if (!isValidEmployee(emp)) {
      logAction("Invalid employee data");
      return;
    }

    if (isDuplicateEmployee(emp.getId())) {
      logAction("Employee exists");
      return;
    }

    if (!saveToDatabase(emp)) {
      logAction("DB not connected");
      return;
    }

    employees.add(emp);
    sendNotification(emp);
    logAction("Added: " + emp.getName());
  }

  // Вынесение проверок в отдельные методы
  private boolean isValidEmployee(Employee emp) {
    return emp != null
        && isValidName(emp.getName())
        && isValidAge(emp.getAge())
        && isValidSalary(emp.getSalary());
  }

  private boolean isValidName(String name) {
    return name != null && !name.trim().isEmpty();
  }

  private boolean isValidAge(int age) {
    return age > 18 && age < 65;
  }

  private boolean isValidSalary(double salary) {
    return salary > 0;
  }

  private boolean isDuplicateEmployee(int id) {
    return employees.stream().anyMatch(e -> e.getId() == id);
  }

  private boolean saveToDatabase(Employee emp) {
    return dbConnection.isConnected() && dbConnection.save(emp);
  }

  private void sendNotification(Employee emp) {
    if (isValidEmail(emp.getEmail())) {
      System.out.println("Sending email to " + emp.getEmail());
    }
  }

  private boolean isValidEmail(String email) {
    return email != null && !email.trim().isEmpty();
  }

  private void logAction(String message) {
    System.out.println("[LOG] " + message);
  }
}
