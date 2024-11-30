package connection;

import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseConnection {
  private static DatabaseConnection instance;

  final private String driver = "com.mysql.jdbc.Driver";
  final private String url = "jdbc:mysql://localhost:3306/agenda";
  final private String user = "root";
  final private String password = "";

  private Connection connection;
  private Statement statement;
  private ResultSet resultSet;

  public DatabaseConnection() {
    this.connect();
  }

  @Override
  public String toString() {
    return "DatabaseConnection{" + "connection=" + this.connection + '}';
  }

  public static synchronized DatabaseConnection getInstance() {
    if (instance == null)
      instance = new DatabaseConnection();

    return instance;
  }

  private void showErrorPane(String message, Exception error) {
    JOptionPane.showMessageDialog(null, message, "Erro na conexão", JOptionPane.ERROR_MESSAGE);
    System.err.println(error);
  }

  public boolean connect() {
    try {
      Class.forName(driver);
      this.connection = DriverManager.getConnection(url, user, password);
      System.out.println("Conectado ao banco de dados!");
      return true;
    } catch (ClassNotFoundException e) {
      this.showErrorPane("Erro ao conectar com o banco de dados. Verifique sua conexão.", e);
      return false;
    } catch (SQLException source) {
      this.showErrorPane("Erro na conexão com o banco de dados. Tente novamente.", source);
      return false;
    }
  }

  public boolean disconnect() {
    try {
      this.connection.close();
      System.out.println("Desconectado do banco de dados!");
      return true;
    } catch (SQLException close) {
      this.showErrorPane("Erro ao desconectar do banco de dados.", close);
      return false;
    }
  }

  public void executeSQL(String sql) {
    try {
      this.statement = this.connection.createStatement();
      this.statement.executeQuery(sql);
    } catch (SQLException sqlException) {
      this.showErrorPane("Erro com banco de dados. Tente novamente.", sqlException);
    }
  }

  public Connection getConnection() {
    try {
      if (this.connection == null || this.connection.isClosed()) 
        this.connect();
    } catch (SQLException e) {
      this.showErrorPane("Erro ao verificar a conexão com banco de dados. Tente novamente.", e);
    }

    return connection;
  }

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

  public Statement getStatement() {
    return statement;
  }

  public void setStatement(Statement statement) {
    this.statement = statement;
  }

  public ResultSet getResultSet() {
    return resultSet;
  }

  public void setResultSet(ResultSet resultSet) {
    this.resultSet = resultSet;
  }
}
