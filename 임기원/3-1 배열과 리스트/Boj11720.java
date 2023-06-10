package org.example;

import java.util.*;

public class Boj11720 {

    public class Main {
        public class Main {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int A[] = new int[N];
                for (int i = 0; i < N; i++) {
                    A[i] = sc.nextInt();
                }
                long sum = 0;
                long max = 0;
                for (int i = 0; i < N; i++) {
                    sum = sum + A[i];
                    max = max < A[i] ? A[i] : max;
                }

                System.out.println(sum * 100.0 / max / N);
            }
        }
    }
}