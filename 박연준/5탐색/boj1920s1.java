package org.example;

import java.io.*;
import java.util.*;

public class boj1920s1 {
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
            int k = Integer.parseInt(st.nextToken());
            // k와 mid를 비교해서 k가 크면 오른쪽 배열 선택 k가 작으면 왼쪽배열 선택
            binary(arr, k);

        }
    }

    static void binary(int[] arr, int k){

        if(arr.length ==0){
            System.out.println(0);
            return;
        }
        if(arr.length ==1 && arr[0] != k){
            System.out.println(0);
            return;
        }
        // 배열을 재정의 해 줘야함.
        int[] tempArr;
        int mid = arr.length/2;
        int qw = arr[mid];

        // 중지 조건


        // 중앙값이 원하는 값보다 크다.
        if(qw > k){
            // tempArr를 arr의 0부터 mid까지
            tempArr = new int[mid];
            for(int j = 0; j< mid; j++){
                tempArr[j] = arr[j];
            }
            binary(tempArr,k);


        }else if(qw < k){
            int temp = mid;
            mid = arr.length- mid-1;

            tempArr = new int[mid];
            for(int j = 0; j< mid; j++){
                tempArr[j] = arr[mid+j+1];
            }
            binary(tempArr,k);
        }else{
            System.out.println(1);
            return;
        }

    }
}
