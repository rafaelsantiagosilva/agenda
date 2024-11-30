package utils;

public class CliBeautifier {
  public static void makeLine(int size) {
    String line = "";

    for (int i = 0; i < size; i++)
      line += "-";

    System.out.println(line);
  }
}