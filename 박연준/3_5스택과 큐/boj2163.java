package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class boj2163 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){
            queue.add(i);
        }

        while(queue.size() != 1){
            queue.poll();
            int temp = queue.poll();
            queue.add(temp);
        }

        System.out.println(queue.poll());

    }

}
