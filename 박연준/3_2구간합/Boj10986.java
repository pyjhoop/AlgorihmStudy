package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  1. 변수할당
 *  2. 합배열 생성후 M으로 나눈 값으로 업데이트
 *  3. 나머지의 개수가 2개 이상인 경우의 수를 더하기
 *
 *  ** long 타입 생각하기
 */

public class Boj10986 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // N(개수), M(구간합)
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long count = 0L;

        // 구간합 배열
        long[] S = new long[N+1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            S[i] = S[i-1]+Integer.parseInt(st1.nextToken());
        }

        // 나머지 배열로 업데이트
        for(int i = 1; i <= N; i++){
            S[i] %= M;
            if(S[i] == 0) count++;
        }

        // 나머지 개수
        // ex) 0 1 2   -> 나머지
        //     3 2 0   -> 나머지의 개수
        long[] remain = new long[M+1];

        for(int i = 1; i <= N; i++){
            long c = S[i];
            remain[(int)c] = remain[(int)c]+1;
        }

        for(int i = 0; i < M; i++){
            count += remain[i] * (remain[i] -1) /2;
        }

        System.out.println(count);

    }
}