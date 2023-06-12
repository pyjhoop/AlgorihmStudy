package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean result = true;


        int[] A = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Stack stack = new Stack();
        int s = 1;

        for(int i = 0; i < N; i++) {
            if(A[i] >= s) {
                while(A[i]>=s) {
                    stack.push(s++);
                    sb.append("+\n");
                }

                stack.pop();
                sb.append("-\n");
            }else {
                int n1 = (int) stack.pop();
                if(n1>A[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                }else {
                    sb.append("-\n");
                }
            }
        }
        if(result) System.out.println(sb);



    }



}
