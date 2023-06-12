package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2750 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 5, 2, 3, 4, 1
        // 2,3,4,1,5
        int temp = 0;
        for(int i = 0; i < n-1; i++){

            for(int j = 0; j < n-1-i; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }

        for(int i: arr){
            System.out.println(i);
        }

    }
}
