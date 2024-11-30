package validation;

import java.util.List;

import javax.swing.JOptionPane;

import models.Contact;

public class InputValidation {
  public static boolean validateInputs(String[] values) {
    for (String value : values) {
      if (value.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos", "Erro",
            JOptionPane.ERROR_MESSAGE);
        return false;
      }
    }

    return true;
  }

  public static boolean nameAlreadyExists(String name, List<Contact> contacts) {
    for (Contact contact : contacts) {
      if (contact.getName().equalsIgnoreCase(name)) {
        JOptionPane.showMessageDialog(null, "Já existe um contato com esse nome", "Erro",
            JOptionPane.ERROR_MESSAGE);
        return true;
      }
    }
    return false;
  }

  public static boolean cpfAlreadyExists(String cpf, List<Contact> contacts) {
    for (Contact contact : contacts) {
      if (contact.getCpf().equalsIgnoreCase(cpf)) {
        JOptionPane.showMessageDialog(null, "Já existe um contato com esse CPF", "Erro",
            JOptionPane.ERROR_MESSAGE);
        return true;
      }
    }
    return false;
  }

  public static boolean cpfAlreadyExistsTwoTimes(String cpf, List<Contact> contacts) {
    int times = 0;

    for (Contact contact : contacts) {
      if (contact.getCpf().equalsIgnoreCase(cpf)) {
        times++;

        if (times > 1) {
          JOptionPane.showMessageDialog(null, "Já existe um contato com esse CPF", "Erro",
              JOptionPane.ERROR_MESSAGE);
          return true;
        }
      }
    }
    return false;
  }
}
