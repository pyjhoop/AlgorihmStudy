package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  1. N 초기화
 *  2. start, end index지정
 *  3. 조건에 따라 포인터 이동
 */

public class Boj2018 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count =1;

        while(endIndex != N){

            if(sum < N){
                sum += ++endIndex;
            }else if(sum > N){
                sum -= startIndex++;
            }else{
                count++;
                sum += ++endIndex;
            }

        }

        System.out.println(count);
        br.close();
    }
}