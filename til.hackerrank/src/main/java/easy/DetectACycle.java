package easy;

import java.util.ArrayList;
import java.util.List;

public class DetectACycle {

  static boolean hasCycle(Node head) {
    List<Node> list = new ArrayList<>();
    while (true) {
      if (head == null) {
        return false;
      }

      Node temp = head.next;
      if (list.contains(temp)) {
        return true;
      }

      list.add(temp);
      head = temp;
    }
  }

  public static void main(String[] args) {
    Node head = new Node();
    System.out.println(hasCycle(head));
  }
}

class Node {

  int data;
  Node next;
}