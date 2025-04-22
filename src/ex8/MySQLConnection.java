package ex8;


class MySQLConnection implements DatabaseConnection {

  @Override
  public boolean isConnected() {
    return true;
  }

  @Override
  public boolean save(Employee emp) {
    return true;
  }
}