package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11659 {
    import java.util.*;
    import java.io.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer =
                    new StringTokenizer(bufferedReader.readLine());
            // 데이터 개수, 질문 개수
            int suNo = Integer.parseInt(stringTokenizer.nextToken());
            int quizNo = Integer.parseInt(stringTokenizer.nextToken());

            // 0번째 인덱스는 값이 0인, 데이터 개수보다 +1개의 배열 생성
            long[] sum = new long[suNo+1];

            // 데이터 입력 받기
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            // 합 배열 생성하기
            for (int i = 1; i <= suNo; i++) {
                sum[i] = sum[i-1] + Integer.parseInt(stringTokenizer.nextToken());
            }

            // i번째 부터 j번째 수까지 합하는 공식은 "구간합 = S[j] - S[i-1]"
            for (int i = 0; i < quizNo; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int j  = Integer.parseInt(stringTokenizer.nextToken());
                int k = Integer.parseInt(stringTokenizer.nextToken());
                System.out.println(sum[k] - sum[j-1]);
            }
        }
    }
}