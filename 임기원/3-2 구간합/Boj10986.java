package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10986 {
    import java.util.*;
    import java.io.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer =
                    new StringTokenizer(bufferedReader.readLine());
            // 배열의 크기, 질문 개수
            int arrSize = Integer.parseInt(stringTokenizer.nextToken());
            int quizNo = Integer.parseInt(stringTokenizer.nextToken());

            // 기본 배열 만들기
            int A[][] =  new int[arrSize+1][arrSize+1];
            for (int i = 1; i <= arrSize; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 1; j <= arrSize; j++) {
                    A[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            // 합 배열 만들기
            int D[][] = new int[arrSize+1][arrSize+1];
            for (int i = 1; i <= arrSize; i++) {
                for (int j = 1; j <= arrSize; j++) {
                    // 합배열 만드는 공식
                    D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
                }
            }

            // 구간 합 계산하기
            for (int i = 0; i < quizNo; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x1 = Integer.parseInt(stringTokenizer.nextToken());
                int y1 = Integer.parseInt(stringTokenizer.nextToken());
                int x2 = Integer.parseInt(stringTokenizer.nextToken());
                int y2 = Integer.parseInt(stringTokenizer.nextToken());

                // 구간 합 계산하는 공식
                int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1 -1][y1-1];
                System.out.println(result);
            }
        }
    }
}