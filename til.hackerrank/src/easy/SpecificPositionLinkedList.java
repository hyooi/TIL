package easy;

import java.io.IOException;
import java.util.Scanner;

public class SpecificPositionLinkedList {

  static class SinglyLinkedListNode {

    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {

    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }
  }

  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep)
      throws IOException {
    while (node != null) {
      System.out.println(String.valueOf(node.data));
//      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
//        bufferedWriter.write(sep);
        System.out.println(sep);
      }
    }
  }

  static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data,
      int position) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    SinglyLinkedListNode target = head;
    for (int i = 0; i < position; i++) {
      target = target.next;
    }

    if (target == null) {
      head = newNode;
    } else {
      target = newNode;
    }
    return head;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    SinglyLinkedList llist = new SinglyLinkedList();

    int llistCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < llistCount; i++) {
      int llistItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      llist.insertNode(llistItem);
    }

    int data = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int position = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

    printSinglyLinkedList(llist_head, " ");
//    bufferedWriter.newLine();

//    bufferedWriter.close();

    scanner.close();
  }
}
