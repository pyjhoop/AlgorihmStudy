package org.example;

import java.io.*;
import java.util.*;

public class boj1715 {
    public static void main(String[] args) throws IOException {
        // 숫자의 총합을 구하는데 순서에 최소값을 구해야 함.
        // 10, 20, 40
        // 10+20 + 30 +40  = 100
        // 10+40 + 50+20 = 120
        // 20 + 40 + 50+10 = 120

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }


        int data1= 0;
        int data2 = 0;
        int sum = 0;
        while(pq.size() != 1){
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1+data2);
        }

        System.out.println(sum);




    }
}
