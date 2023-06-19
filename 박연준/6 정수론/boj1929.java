package org.example;

import java.io.*;
import java.util.*;

public class boj1929  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        //에스토스테네스 체
        for(int i = 2; i<= n ;i++){
            arr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(n); i++){
            // 이미 0으로 변한 인덱스를 패스 시킴
            if(arr[i] == 0) continue;
            
            // 배수를 찾는 거임
            for(int j = i+i; j<= n; j+=i){
                arr[j] = 0;
            }
        }

        for(int i =m; i<=n; i++){
            if(arr[i] != 0){
                System.out.println(arr[i]);
            }
        }
    }


}
