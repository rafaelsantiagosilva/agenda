package validation;

public class CpfValidation {
  public static boolean isCpfValid(String cpf) {
    if (!isCpfFormatValid(cpf))
      return false;

    String lastCpfDigits = filterNumbers(cpf);
    lastCpfDigits = lastCpfDigits.substring(9, 11);
    String sumRemainders = firstSum(cpf) + secondSum(cpf, firstSum(cpf));

    if (lastCpfDigits.equalsIgnoreCase(sumRemainders))
      return true;
    else
      return false;
  }

  private static String filterNumbers(String cpf) {
    String cpfNumbers = "", digits = "0123456789";
    int charPosition = 0;

    while (charPosition < cpf.length()) {
      String currentChar = cpf.substring(charPosition, charPosition + 1);

      if (digits.indexOf(currentChar) != -1)
        cpfNumbers += currentChar;

      charPosition++;
    }

    return cpfNumbers;
  }

  private static boolean isCpfFormatValid(String cpf) {
    if (cpf.length() != 14)
      return false;

    if (!cpf.substring(3, 4).equalsIgnoreCase(".") ||
        !cpf.substring(7, 8).equalsIgnoreCase(".") ||
        !cpf.substring(11, 12).equalsIgnoreCase("-"))
      return false;

    String cpfNumbers = filterNumbers(cpf);
    if (cpfNumbers.length() < 11)
      return false;

    return true;
  }

  private static String firstSum(String cpf) {
    int multiplier = 2, sum = 0;
    String cpfNumbers = filterNumbers(cpf);

    for (int charPosition = 8; charPosition > -1; charPosition--) {
      String currentChar = cpfNumbers.substring(charPosition, charPosition + 1);
      sum += Integer.parseInt(currentChar) * multiplier;
      multiplier++;
    }

    sum = sum * 10 % 11;

    if (sum == 10 || sum == 11)
      return "0";

    return String.valueOf(sum);
  }

  private static String secondSum(String cpf, String firstSumRemainder) {
    int multiplier = 2, sum = 0;
    String cpfNumbers = filterNumbers(cpf) + firstSumRemainder;

    for (int charPosition = 9; charPosition > -1; charPosition--) {
      String currentChar = cpfNumbers.substring(charPosition, charPosition + 1);
      sum += Integer.parseInt(currentChar) * multiplier;
      multiplier++;
    }

    sum = sum * 10 % 11;

    if (sum == 10 || sum == 11)
      return "0";

    return String.valueOf(sum);
  }
}
