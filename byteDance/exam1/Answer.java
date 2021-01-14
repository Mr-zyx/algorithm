package byteDance.exam1;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Answer {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("please input how many data need to be fixed: ");
    int lineNum = scanner.nextInt();
    System.out.println("please input data: ");
    String[] inputStrs = new String[lineNum];
    for (int i = 0; i < lineNum; i++) {
      inputStrs[i] = scanner.next();
    }

    System.out.println("fixed data: ");
    for (int i = 0; i < lineNum; i++) {
      System.out.println(reviseInput(inputStrs[i]));
    }
  }

  private static String reviseInput(String inputStr) {
    inputStr = reviseRule1(inputStr);
    return reviseRule2(inputStr);
  }

  private static String reviseRule1(String inputStr) {
    if (inputStr.length() < 3) {
      return inputStr;
    }
    String[] chars = inputStr.split("");
    for (int i = 2; i < chars.length; i++) {
      if (Objects.equals(chars[i], chars[i - 1]) && Objects.equals(chars[i], chars[i - 2])) {
        chars[i] = null;
      }
    }
    return Arrays.stream(chars).anyMatch(Objects::isNull) ?
        reviseRule1(Arrays.stream(chars).filter(Objects::nonNull).collect(Collectors.joining()))
        : Arrays.stream(chars).filter(Objects::nonNull).collect(Collectors.joining());
  }

  private static String reviseRule2(String inputStr) {
    if (inputStr.length() < 4) {
      return inputStr;
    }
    String[] chars = inputStr.split("");
    for (int i = 3; i < chars.length; i++) {
      if (Objects.equals(chars[i], chars[i - 1]) && Objects.equals(chars[i - 2], chars[i - 3])) {
        chars[i] = null;
      }
    }
    return Arrays.stream(chars).anyMatch(Objects::isNull) ?
        reviseRule1(Arrays.stream(chars).filter(Objects::nonNull).collect(Collectors.joining()))
        : Arrays.stream(chars).filter(Objects::nonNull).collect(Collectors.joining());
  }
}
