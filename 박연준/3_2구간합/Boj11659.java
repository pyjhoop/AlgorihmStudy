package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  1. M, N 입력받음
 *  2. 숫자들을 입력받아 배열에 저장
 *  3. S[j] - S[i-1] 공식 사용해서 값 구함
 *  4. 출력
 */

public class Boj11659 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //  N(크기), M(횟수)
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 합 배열
        int[] S = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <=N; i++){

                S[i] = S[i-1] + Integer.parseInt(st.nextToken());

        }

        // 구간에 대한 값
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            sb.append(-S[Integer.parseInt(st.nextToken())-1]+S[Integer.parseInt(st.nextToken())])
                    .append("\n");
        }

        // 출력
        System.out.println(sb);

    }
}