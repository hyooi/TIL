package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

//[INPUT]
//12
//ENTER John 3.75 50
//ENTER Mark 3.8 24
//ENTER Shafaet 3.7 35
//SERVED
//SERVED
//ENTER Samiha 3.85 36
//SERVED
//ENTER Ashley 3.9 42
//ENTER Maria 3.6 46
//ENTER Anik 3.95 49
//ENTER Dan 3.95 50
//SERVED
//
//[OUTPUT]
//Dan
//Ashley
//Shafaet
//Maria
public class JavaPriorityQueue {

  private static class Student {

    private int id;
    private String name;
    private double cgpa;

    Student(int id, String name, double cgpa) {
      this.id = id;
      this.name = name;
      this.cgpa = cgpa;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }


    public double getCgpa() {
      return cgpa;
    }
  }

  private static class Priorities {

    private static Comparator<Student> comparator = (o1, o2) -> {
      if (o1.getCgpa() != o2.getCgpa()) {
        return Double.compare(o2.getCgpa(), o1.getCgpa());
      }

      if (!o1.getName().equals(o2.getName())) {
        return o1.getName().compareTo(o2.getName());
      }

      return Integer.compare(o1.getId(), o2.getId());
    };


    public static List<Student> getStudents(List<String> events) {
      PriorityQueue<Student> queue = new PriorityQueue<>(comparator);

      for (String event : events) {
        String[] splitData = event.split(" ");
        if (splitData.length == 1) {
          queue.remove(queue.peek());
        } else {

          Student student = new Student(Integer.parseInt(splitData[3]),
              splitData[1],
              Double.parseDouble(splitData[2]));

          queue.add(student);
        }
      }

      return queue.stream().sorted(comparator).collect(Collectors.toList());
    }
  }

  private final static Scanner scan = new Scanner(System.in);
  private final static Priorities priorities = new Priorities();

  public static void main(String[] args) {
    int totalEvents = Integer.parseInt(scan.nextLine());
    List<String> events = new ArrayList<>();

    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event);
    }

    List<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st : students) {
        System.out.println(st.getName());
      }
    }
  }
}
