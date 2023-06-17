package org.example;

public class Boj1940 {
import java.util .*;
import java.io .*;
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            // 재료의 수, 갑옷만드는 숫자
            int N = Integer.parseInt(bufferedReader.readLine());
            int M = Integer.parseInt(bufferedReader.readLine());

            // 배열로 만들기
            int[] A = new int[N];
            StringTokenizer stringToeknizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(stringToeknizer.nextToken());
            }
            // 정렬
            Arrays.sort(A);
            int count = 0;
            int startIndex = 0;
            int endIndex = N - 1;

            // 두값이 만나면 while문 종료
            while (startIndex < endIndex){
                if(A[startIndex] + A[endIndex] < M){ // 두값의 합이 M보다 작을때
                    startIndex++;
                }else if(A[startIndex] + A[endIndex] > M){ // 두값의 합이 M보다 클때
                    endIndex--;
                }else{ // 두값의 합이 M과 같을때
                    count++;
                    startIndex++;
                    endIndex--;
                }
            }

            System.out.println(count);
            bufferedReader.close();
        }
    }
}