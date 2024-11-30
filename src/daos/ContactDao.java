package daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import connection.DatabaseConnection;
import models.Contact;

public class ContactDao implements DaoInterface<Contact> {
  final private DatabaseConnection dbConnection = DatabaseConnection.getInstance();

  @Override
  public void create(Contact contact) {
    String sql = "INSERT INTO contacts (name, address, neighborhood, city, state, phone_number, email, cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection connection = dbConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);) {
      stmt.setString(1, contact.getName());
      stmt.setString(2, contact.getAdress());
      stmt.setString(3, contact.getNeighborhood());
      stmt.setString(4, contact.getCity());
      stmt.setString(5, contact.getState());
      stmt.setString(6, contact.getPhoneNumber());
      stmt.setString(7, contact.getEmail());
      stmt.setString(8, contact.getCpf());
      stmt.executeUpdate();
    } catch (SQLException sqlException) {
      System.err.println("Error: " + sqlException.getMessage() + "\n");
      sqlException.printStackTrace();
    }
  }

  @Override
  public ArrayList<Contact> readAll() {
    ArrayList<Contact> contacts = new ArrayList<Contact>();

    String sql = "SELECT * FROM contacts";

    try (Connection connection = dbConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        Contact contact = new Contact(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("address"),
            rs.getString("neighborhood"),
            rs.getString("city"),
            rs.getString("state"),
            rs.getString("phone_number"),
            rs.getString("email"),
            rs.getString("cpf"));
        contacts.add(contact);
      }
    } catch (SQLException sqlException) {
      System.err.println("Error: " + sqlException.getMessage() + "\n");
      sqlException.printStackTrace();
    }

    return contacts;
  }

  public ArrayList<Contact> readAllOrderedByName() {
    ArrayList<Contact> contacts = new ArrayList<Contact>();

    String sql = "SELECT * FROM contacts ORDER BY name";

    try (Connection connection = dbConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        Contact contact = new Contact(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("address"),
            rs.getString("neighborhood"),
            rs.getString("city"),
            rs.getString("state"),
            rs.getString("phone_number"),
            rs.getString("email"),
            rs.getString("cpf"));
        contacts.add(contact);
      }
    } catch (SQLException sqlException) {
      System.err.println("Error: " + sqlException.getMessage() + "\n");
      sqlException.printStackTrace();
    }

    return contacts;
  }

  @Override
  public Contact readById(int id) {
    Contact contact = null;

    String sql = "SELECT * FROM contacts WHERE id = ?";

    try (Connection connection = dbConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);) {
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        contact = new Contact(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("address"),
            rs.getString("neighborhood"),
            rs.getString("city"),
            rs.getString("state"),
            rs.getString("phone_number"),
            rs.getString("email"),
            rs.getString("cpf"));
      }
    } catch (SQLException sqlException) {
      System.err.println("Error: " + sqlException.getMessage() + "\n");
      sqlException.printStackTrace();
    }

    return contact;
  }

  @Override
  public void update(Contact contact) {
    String sql = "UPDATE contacts SET name = ?, address = ?, neighborhood = ?, city = ?, state = ?, phone_number = ?, email = ?, cpf = ? WHERE id = ?";

    try (Connection connection = dbConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);) {
      stmt.setString(1, contact.getName());
      stmt.setString(2, contact.getAdress());
      stmt.setString(3, contact.getNeighborhood());
      stmt.setString(4, contact.getCity());
      stmt.setString(5, contact.getState());
      stmt.setString(6, contact.getPhoneNumber());
      stmt.setString(7, contact.getEmail());
      stmt.setString(8, contact.getCpf());
      stmt.setInt(9, contact.getId());
      stmt.executeUpdate();
    } catch (SQLException sqlException) {
      System.err.println("Error: " + sqlException.getMessage() + "\n");
      sqlException.printStackTrace();
    }
  }

  @Override
  public void delete(int id) {
    String sql = "DELETE FROM contacts WHERE id = ?";

    try (Connection connection = dbConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);) {
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException sqlException) {
      System.err.println("Error: " + sqlException.getMessage() + "\n");
      sqlException.printStackTrace();
    }
  }
}
