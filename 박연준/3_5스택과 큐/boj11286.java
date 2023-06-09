package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj11286 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2)->{
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2){
                return o1 > o2 ? 1:-1;
            }else{
                return abs1-abs2;
            }
        });

        for(int i = 0; i < n; i++){
            int request = Integer.parseInt(br.readLine());

            if(request == 0){
                if(que.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(que.poll());
                }
            }else {
                que.add(request);
            }
        }

    }

}
