package easy;

public class Fish {

  public static int solution(int[] A, int[] B) {
    int eatenCnt = 0, upstreamMax = 0, downstreamMax = 0;
    for (int i=0; i<A.length; i++) {
      if(B[i] == 0) {
        if(downstreamMax > A[i]) {
          eatenCnt++;
        }
        upstreamMax = upstreamMax == 0? A[i] : Math.max(upstreamMax, A[i]);

        continue;
      }

      if(B[i] == 1) {
        if(upstreamMax > A[i]) {
          eatenCnt++;
        }
        downstreamMax = downstreamMax == 0? A[i] : Math.max(downstreamMax, A[i]);
      }
    }

    return A.length - eatenCnt;
  }

  /*
  A -> 물고기크기
  B -> 0: 상류로, 1: 하류로
  남은 물고기 수?
   */
  public static void main(String[] args) {
    System.out.println(solution(new int[]{4,3,2,1,5}, new int[]{0,1,0,0,0})); //2
    System.out.println(solution(new int[]{4,3}, new int[]{0,0})); //2
    System.out.println(solution(new int[]{4,3}, new int[]{1,0})); //2
  }
}
