package ex8;

interface DatabaseConnection {

  boolean isConnected();

  boolean save(Employee emp);
}
