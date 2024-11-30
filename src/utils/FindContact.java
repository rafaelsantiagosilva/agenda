package utils;

import java.util.List;
import models.Contact;

public class FindContact {
  public static int findIndexOfContactByName(String name, List<Contact> contacts) {
    for (int i = 0; i < contacts.size(); i++) {
      if (contacts.get(i).getName().equals(name))
        return i;
    }

    return -1;
  }
}
