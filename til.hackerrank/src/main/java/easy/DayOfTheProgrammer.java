package easy;

public class DayOfTheProgrammer {
  public static String dayOfProgrammer(int year) {
    if (1918 == year) { //1918년은 1월 31일의 다음날이 2월 14일이었음
      return "26.09." + year;
    }

    boolean leapYear = isLeapYear(year);
    if (leapYear) {
      return "12.09." + year;
    } else {
      return "13.09." + year;
    }
  }

  private static boolean isLeapYear(int year) {
    if (year <= 1917) {
      return year % 4 == 0;
    }

    if (year % 400 == 0) {
      return true;
    }

    return year % 4 == 0 && year % 100 != 0;
  }

  public static void main(String[] args) {
//    System.out.println(dayOfProgrammer(1984)); //12.09.1984
//    System.out.println(dayOfProgrammer(2017)); //13.09.2017
//    System.out.println(dayOfProgrammer(2016)); //12.09.2016
//    System.out.println(dayOfProgrammer(1800)); //12.09.1800
//    System.out.println(dayOfProgrammer(1700)); //12.09.1700
//    System.out.println(dayOfProgrammer(2700)); //13.09.2700
    System.out.println(dayOfProgrammer(1918)); //26.09.1918
  }
}
