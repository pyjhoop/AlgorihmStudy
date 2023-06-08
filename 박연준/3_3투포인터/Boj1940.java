package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  1. N 초기화
 *  2. start, end index지정
 *  3. 조건에 따라 포인터 이동
 */

public class Boj1940 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N(재료의 개수) M(두수의 합)
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int startIndex = 0;
        int endIndex = N-1;
        int count = 0;


        // N개의 재료들
        String str = br.readLine();

        List<Integer> list = Arrays.asList(str.split(" ")).stream()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        while(endIndex > startIndex){
            if(list.get(startIndex) + list.get(endIndex) < M){
                startIndex++;
            }else if(list.get(startIndex) + list.get(endIndex) > M){
                endIndex--;
            }else{
                count++;
                startIndex++;
                endIndex--;
            }
        }

        System.out.println(count);
        br.close();

    }
}