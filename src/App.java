/**
 * @author Rafael Santiago, Lucas Tompson
 * @since 2023
 * @version 1.0
 */

import views.contactsnavigator.*; 

public class App {
  public static void main(String[] args) {
    try {
      ContactsNavigator view = new ContactsNavigator();
      view.setVisible(true);
    } catch (Exception e) {
      System.err.println("Error: " + e);
    }      
  }
}
