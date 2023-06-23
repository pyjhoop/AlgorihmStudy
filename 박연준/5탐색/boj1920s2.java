package org.example;

import java.io.*;
import java.util.*;

public class boj1920s2 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i< n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 이진 탐색을 위해서 먼저 배열을 정렬하지 오름차순으로
        Arrays.sort(arr);
        // 중앙값을 찾자

        for(int i = 0; i < m; i++){
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());

            // 이진 탐색 시작
            int start = 0;
            int end = arr.length -1;

            while(start <= end){
                int midi = (start + end)/2;
                int midV = arr[midi];

                if(midV>target){
                    end=midi-1;
                }else if(midV<target){
                    start = midi +1;
                }else{
                    find = true;
                    break;
                }
            }

            if(find){
                System.out.println(1);
            }else{
                System.out.println(0);
            }

        }
    }



}
