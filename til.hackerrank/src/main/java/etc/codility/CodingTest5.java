package etc.codility;

public class CodingTest5 {

  public static int solution(int N, int K) {
    int result = 0, sum = 0;
    for (int i=N; i>0; i--) {
      if(sum < K && i <= K) {
        if (sum + i <= K) {
          sum += i;
          result++;
        }

        if(sum == K) return result;
      }
    }

    return -1;
  }

  /*
  정확히 k리터의 물을 1...N리터짜리 N개의 빈잔에 부어야 함. 필요한 잔의 수?
  N=5,
   */
  public static void main(String[] args) {
    System.out.println(solution(5, 8)); //2. 용량 3 및 5짜리 두개
    System.out.println(solution(4, 10)); //4. 모든 유리잔 사용
    System.out.println(solution(1, 2)); //-1. 부을수 없음
    System.out.println(solution(10, 5)); //1. 5자리!
  }
}
