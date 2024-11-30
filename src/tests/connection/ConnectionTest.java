package tests.connection;

import utils.CliBeautifier;
import connection.DatabaseConnection;

public class ConnectionTest {
  public static void main(String[] args) {
    DatabaseConnection databaseConnection = new DatabaseConnection();

    CliBeautifier.makeLine(90);
    System.out.println(databaseConnection);
    CliBeautifier.makeLine(90);
  }
}
