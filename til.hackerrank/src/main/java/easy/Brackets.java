package easy;

import java.util.Stack;

public class Brackets {

  public static int solution(String S) {
    if (S == null || S.equals("")) return 1;

    char[] sArray = S.toCharArray();
    if(sArray.length %2 == 1) return 0;

    char first = S.charAt(0);
    if (first == ')' || first == '}' || first == ']') return 0;

    Stack<Character> stack = new Stack<>();
    for(char temp : sArray) {
      if (temp == '(' || temp == '{' || temp == '[') {
        stack.push(temp);
        continue;
      }

      if(stack.empty()) return 0;

      if (temp == ')') {
        if (stack.pop() != '(') return 0;
      }

      if (temp == '}') {
        if (stack.pop() != '{') return 0;
      }

      if (temp == ']') {
        if (stack.pop() != '[') return 0;
      }
    }

    return stack.empty()? 1 : 0;
  }

  /*
  적절히 중첩되어있으면 -> 1
  아니면 -> 0
   */
  public static void main(String[] args) {
    System.out.println(solution("{[()()]}"));
    System.out.println(solution("([)()]"));
    System.out.println(solution(")("));
    System.out.println(solution(""));
    System.out.println(solution("{{{{"));
    System.out.println(solution("())(()"));
  }
}
