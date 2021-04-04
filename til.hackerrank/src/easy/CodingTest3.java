package easy;

import java.util.EmptyStackException;
import java.util.Stack;

public class CodingTest3 {

  public static void main(String[] args) {
    String[] compressed = ("2(2(hi)2(co))x2(bo)").split("");

    Stack<String> stack = new Stack<>();
    for (String c : compressed) {
      if (c.equals("(")) {
        stack.push(c);
        continue;
      }

      if (c.equals(")")) {
        String text = null;
        while (true) {
          String temp = stack.pop();
          if (temp.equals("(")) {
            continue;
          }

          if (isDigit(temp)) {
            String before = getBeforeValue(stack);
            if (!before.equals("") && !isDigit(before) && !before.equals("(")) {
              stack.push(stack.pop() + multiplyString(text, Integer.parseInt(temp)));
              break;
            }

            stack.push(multiplyString(text, Integer.parseInt(temp)));
            break;
          }

          text = temp;
        }

        continue;
      }

      String temp = getBeforeValue(stack);
      if (isDigit(c)) {
        if (isDigit(temp)) {
          stack.push(stack.pop() + c);
        } else {
          stack.push(c);
        }
        continue;
      }

      if (!isDigit(temp) && !temp.equals("(")) {
        stack.push(stack.pop() + c);
        continue;
      }
      stack.push(c);

    }

    System.out.println(stack.pop());

  }

  private static String getBeforeValue(Stack<String> stack) {
    try {
      return stack.peek();
    } catch (EmptyStackException e) {
      return "";
    }
  }


  private static boolean isDigit(String c) {
    try {
      Integer.valueOf(c);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private static String multiplyString(String text, int m) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < m; i++) {
      builder.append(text);
    }

    return builder.toString();
  }
}
