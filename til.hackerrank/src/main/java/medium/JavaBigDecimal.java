package medium;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JavaBigDecimal {

  public static void main(String[] args) {
    /*
    String[] nums = {
        "-100",
        "50",
        "0",
        "56.6",
        "90",
        "0.12",
        ".12",
        "02.34",
        "000.000"
    };
    */

    Scanner sc= new Scanner(System.in);
    int n=sc.nextInt();
    String []s=new String[n+2];
    for(int i=0;i<n;i++){
      s[i]=sc.next();
    }
    sc.close();

    Map<BigDecimal, List<String>> numMap = new HashMap<>();
    for(int i = 0; i<n; i++){
      BigDecimal tempDec = new BigDecimal(s[i]);
      List<String> tempList = numMap.getOrDefault(tempDec, new ArrayList<>());
      tempList.add(s[i]);

      numMap.put(tempDec, tempList);
    }

    BigDecimal[] bDec = numMap.keySet().toArray(new BigDecimal[0]);
    Arrays.sort(bDec, Comparator.reverseOrder());

    int j = 0;
    for (BigDecimal temp : bDec){
      List<String> tempList = numMap.get(temp);
      for(String str : tempList) {
        s[j]=str;
        j++;
      }
    }

    //Output
    for(int i=0;i<n;i++)
    {
      System.out.println(s[i]);
    }
  }
}
