package org.example;

import java.util.*;
import java.io.*;

public class boj11047 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] arr = new int[n];

        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //k와 작거나 같은 값을 찾자

        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] <= k){
                int temp = k/arr[i];
                count += temp;
                k = k%arr[i];
            }
        }



        System.out.println(count);




    }
}
