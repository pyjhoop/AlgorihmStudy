package org.example;

//  수 정렬하기 1
public class Boj2750 {
import java.util .*;
import java.io .*;
    public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(Sysyem.in);
            int N = sc.nextInt(); // 수의 개수 입력받기
            int[] A = new int[N]; // 배열 생성하기
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - 1 - i; j++) {
                    if(A[j] > A[j+1]){ // 인접한 값과 비교
                        int temp = A[j]; // 위치 바꾸기
                        A[j] = A[j + 1];
                        A[j+1] = temp;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                System.out.println(A[i]);
            }
        }
    }
}