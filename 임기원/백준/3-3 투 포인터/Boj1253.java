package org.example;

// 좋은 수 구하기
public class Boj1253 {
import java.util .*;
import java.io .*;
import java.util.Arrays;
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            // 확인할 숫자 수
            int N = Integer.parseInt(bufferedReader.readLine());

            // long타입으로 초기화
            long[] A = new long[N];
            StringTokenizer stringToeknizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(stringToeknizer.nextToken());
            }

            // 데이터 정렬
            Arrays.sort(A);

            // 결과값
            int count = 0;

            // 투포인터 알고리즘
            for (int k = 0; k < N; k++) {
                long find = A[k];
                int i = 0;
                int j = N - 1;

                // 두개의 포인터가 만날때까지
                while (i<j){
                    if(A[i]+A[j] == find){
                        if(i != k && j != k){ // 본인이 아닐때
                            count++;
                            break;
                        }else if(i == k){ // i가 k와 같을때 i++
                            i++;
                        }else if(j == k){
                            j--;
                        }
                    }else if (A[i]+A[j] > find){
                        j--;
                    }else {
                        i++;
                    }
                }
            }

            System.out.println(count);
            bufferedReader.close();
        }
    }
}