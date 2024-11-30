package tests.daos;

import daos.ContactDao;
import models.Contact;
import utils.CliBeautifier;

import java.util.List;

public class ContactDaoTest {
  private final static ContactDao contactDao = new ContactDao();

  public static void main(String[] args) {
    try {
      // create();
      // readAll();
      // update(9);
      // readById(9);
      // delete(9);
      // readAll();
      readAllOrderedByName();
    } catch (Exception e) {
      System.err.println("Error: " + e);
    }
  }

  private static void create() throws Exception {
    Contact contact = new Contact(
        0,
        "Fulano",
        "Rua dos Bobos, 0",
        "Centro",
        "São Paulo",
        "SP",
        "(011) 976-543-458",
        "fulano.gmail.com",
        "226.641.200-00");

    contactDao.create(contact);
  }

  private static void readAll() throws Exception {
    List<Contact> contacts = contactDao.readAll();

    for (Contact contact : contacts) {
      CliBeautifier.makeLine(60);
      System.out.println(contact);
      CliBeautifier.makeLine(60);
    }
  }

  private static void readAllOrderedByName() throws Exception {
    List<Contact> contacts = contactDao.readAllOrderedByName();

    for (Contact contact : contacts) {
      CliBeautifier.makeLine(60);
      System.out.println(contact);
      CliBeautifier.makeLine(60);
    }
  }

  private static void readById(int id) throws Exception {
    Contact contact = contactDao.readById(id);
    System.out.println(contact);
  }

  private static void update(int id) throws Exception {
    Contact contact = new Contact(
        id,
        "Fulano",
        "Rua dos Bobos, 0",
        "Centro",
        "Rio de Janeiro",
        "RJ",
        "(011) 976-543-458",
        "fulano.gmail.com",
        "226.641.200-01");

    contactDao.update(contact);
  }

  private static void delete(int id) throws Exception {
    contactDao.delete(id);
    System.out.println("Deleted with success!");
  }
}
