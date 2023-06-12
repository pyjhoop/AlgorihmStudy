package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


public class boj1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String[] tempArr = str.split("");
        Integer[] arr = new Integer[tempArr.length];
        for(int i = 0; i<tempArr.length; i++) {
            arr[i] = Integer.parseInt(tempArr[i]);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }



    }
}
