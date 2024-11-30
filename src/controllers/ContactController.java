package controllers;

import daos.ContactDao;
import models.Contact;

import java.util.ArrayList;

public class ContactController {
  private final ContactDao contactDao = new ContactDao();

  public void addContact(Contact contact) throws Exception {
    contactDao.create(contact);
  }

  public ArrayList<Contact> getContacts() throws Exception {
    return contactDao.readAll();
  }

  public ArrayList<Contact> getContactsInAlphabeticalOrder() throws Exception {
    return contactDao.readAllOrderedByName();
  }

  public Contact getContactById(int id) throws Exception {
    return contactDao.readById(id);
  }

  public void updateContact(Contact contact) throws Exception {
    contactDao.update(contact);
  }

  public void deleteContact(int id) throws Exception {
    contactDao.delete(id);
  }
}
