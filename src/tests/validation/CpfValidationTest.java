package tests.validation;

import validation.*;
import utils.CliBeautifier;

public class CpfValidationTest {
  public static void main(String[] args) {
    String[] cpfsCorrect = {
        "123.456.789-09",
        "111.444.777-35"
    };

    String[] cpfsIncorrect = {
        "123.456.78-90",
        "123.456.78A-09",
        "123.456.789-00",
        "12345678909",
        "@123.456.789-09#",
        "xxx.xxx.xxx-xx2"
    };

    for (String cpf : cpfsCorrect) {
      CliBeautifier.makeLine(60);
      System.out.println("CPF " + cpf + " is valid: " + CpfValidation.isCpfValid(cpf));
      CliBeautifier.makeLine(60);
    }

    System.out.print('\n');

    for (String cpf : cpfsIncorrect) {
      CliBeautifier.makeLine(60);
      System.out.println("CPF " + cpf + " is valid: " + CpfValidation.isCpfValid(cpf));
      CliBeautifier.makeLine(60);
    }
  }
}
