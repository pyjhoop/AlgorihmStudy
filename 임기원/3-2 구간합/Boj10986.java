// 나머지 합 구하기
public class Boj10986 {
    import java.util.*;
    import java.io.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            Scanner sc = new Scanner(System.in);
            // 수열의 개수
            int N = sc.nextInt();
            // 나눠떨어져야 하는 수
            int M = sc.nextInt();

            // 합배열 선언
            long[] S = new long[N];
            long[] C = new long[M];
            long answer = 0;

            // 값 입력 받기
            S[0] = sc.nextInt();

            // 수열 합 배열 만들기
            for (int i = 1; i < N; i++) {
                S[i] = S[i-1] + sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                int remainder = (int) (S[i] % M);
                // 나눴을때 나머지가 0인 값 카운트
                if(remainder == 0) answer++;
                // 나머지가 같은 인덱스의 개수 카운팅하기
                C[remainder]++;
            }

            for (int i = 0; i < M; i++) {
                if(C[i] > 1){
                    // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
                    answer = answer + (C[i] * (C[i] - 1) / 2);
                }
            }

            System.out.println(answer);
        }
    }
}