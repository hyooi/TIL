package easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class MeetingRoom {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] nm = scan.nextLine().split(" ");
    int roomCount = Integer.parseInt(nm[0]);
    int meetingCount = Integer.parseInt(nm[1]);

    Map<String, List<String>> roomInfo = new HashMap<>();
    for (int i=0; i<roomCount; i++) {
      String roomName = scan.nextLine();
      roomInfo.put(roomName, new ArrayList<>());
    }

    for (int i=0; i<meetingCount; i++) {
      String[] meetingInfo = scan.nextLine().split(" ");
      List<String> room = roomInfo.get(meetingInfo[0]);
      room.add(meetingInfo[1] + "-" + meetingInfo[2]);

      room.sort(Comparator.comparing(s -> {
        String[] temp = s.split("-");
        return Integer.parseInt(temp[0]);
      }));
    }

    Object[] keys = roomInfo.keySet()
        .stream()
        .sorted()
        .toArray();

    for (int i=0; i<keys.length; i++) {
      System.out.println("Room " + keys[i] + ":");
      List<String> result = checkList(roomInfo.get(keys[i]));

      if (result.size() == 0) {
        System.out.println("Not available");
      } else {
        System.out.println(result.size() + " available:");
        result.forEach(System.out::println);
      }

      if (i+1 != keys.length) {
        System.out.println("-----");
      }
    }

    scan.close();
  }

  private static List<String> checkList(List<String> room) {
    List<String> result = new ArrayList<String>();
    if(room.size() == 0) {
      result.add("09-18");
      return result;
    }

    for(int i=0; i<room.size(); i++) {
      String[] temp = room.get(i).split("-");
      int startTime = Integer.parseInt(temp[0]);
      int endTime = Integer.parseInt(temp[1]);

      if (i==0 && (startTime != 9)) {
        result.add("09-" + startTime);
      }

      if ((i+1)==room.size() && endTime != 18) {
        result.add(endTime + "-18");
        break;
      }

      if (i+1 == room.size()) {
        break;
      }

      String[] temp2 = room.get(i+1).split("-");
      int startTime2 = Integer.parseInt(temp2[0]);

      if ((startTime2 - endTime) > 0) {
        result.add(endTime + "-" + startTime2);
      }
    }

    return result;
  }
}
