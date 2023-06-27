package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj5585 {

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int rest = 1000-n;

        int[] arr = {1,5,10,50,100,500};
        int count = 0;

        //1. 반복문으로

        while(rest != 0){
            if(rest >= 500){
                count += rest / 500;
                rest = rest %500;
            }
            int index = 0;

            for(int i = 0; i< arr.length; i++){
                if(rest < arr[i]){
                    count += rest / arr[i-1];
                    rest = rest %arr[i-1];
                }
            }
        }

        System.out.println(count);

    }

}
