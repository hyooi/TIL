package etc.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

// 모든 마이크로 서비스에 대한 사용자 방문수를 집계함
class VisitorCounter {

  // 사용자별(id별) 방문 횟수 리턴함
  // 특정 MSA에 대한 사용자 당 총 방문 수
  public static Map<Long, Long> count(Map<String, UserStats>... visits) { //map key는 long으로 변환
    // 가능. 만약 안되면 그 entry는 skip. Userstats도 null이면 skip
    Map<Long, Long> result = new HashMap<>();
    if (visits == null) {
      return result;
    }

    Arrays.stream(visits)
        .filter(Objects::nonNull)
        .forEach(v -> {
          v.entrySet()
              .stream()
              .filter(e -> e.getValue() != null)
              .forEach(e -> {
                try {
                  long key = Long.parseLong(e.getKey());
                  e.getValue()
                      .getVisitCount()
                      .ifPresent(aLong -> result.put(key, result.getOrDefault(key, 0L) + aLong));
                } catch (NumberFormatException ignored) {
                }
              });
        });

    return result;
  }


  private static class UserStats {

    Optional<Long> visitCount; //not null. empty일순 있음. empty면 건너뛰기

    public Optional<Long> getVisitCount() {
      return visitCount;
    }

    public void setVisitCount(Optional<Long> visitCount) {
      this.visitCount = visitCount;
    }
  }

  public static void main(String[] args) {
    UserStats stats1 = new UserStats();
    stats1.setVisitCount(Optional.of(10L));

    UserStats stats2 = new UserStats();
    stats2.setVisitCount(Optional.empty());

    UserStats stats3 = new UserStats();
    stats3.setVisitCount(Optional.of(20L));

    Map<String, UserStats> map1 = new HashMap<>();
    map1.put("1", stats1);
    map1.put("aaa", new UserStats());
    map1.put("3", stats2);
    map1.put("4", null);
    map1.put("5", stats3);

    Map<String, UserStats> map2 = new HashMap<>();
    map2.put("1", stats1);
    map2.put("aaa", new UserStats());
    map2.put("3", stats2);
    map2.put("4", null);
    map2.put("5", stats3);

    System.out.println(VisitorCounter.count(map1, map2, new HashMap<>(), null));
  }
}
