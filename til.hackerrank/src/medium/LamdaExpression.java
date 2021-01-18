package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LamdaExpression {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return a -> a%2 == 1;
    }

    public PerformOperation isPrime() {
        return a -> {
            int cnt = 0;
            for(int i = 1; i<=a; i++) {
                if(a%i ==0){
                    cnt++;
                }
            }

            return cnt ==2;
        };
    }

    public PerformOperation isPalindrome() {
        return a -> {
            byte[] array = String.valueOf(a).getBytes();
            byte[] oppArray = new byte[array.length];
            for(int i =0; i<array.length; i++){
                oppArray[array.length - (i+1)] = array[i];
            }

            return a == Integer.parseInt(new String(oppArray));
        };
    }
}