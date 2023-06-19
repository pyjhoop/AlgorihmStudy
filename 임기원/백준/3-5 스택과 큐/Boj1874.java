package org.example;

//  스택으로 오름차순 수열 만들기
public class Boj12891 {
import java.util .*;
import java.io .*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays;
    public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            StringBuffer bf = new StringBuffer();
            int num = 1;
            boolean result = true;
            for (int i = 0; i < A.length; i++) {
                int su = A[i];
                if(su >= num){
                    while(su >= num){
                        stack.push(num++);
                        bf.append("+\n");
                    }
                    stack.pop();
                    bf.append("-\n");
                }else{
                    int n = stack.pop();
                    if(n > su){
                        System.out.println("NO");
                        result = false;
                        break;
                    }else {
                        bf.append("-\n");
                    }
                }
            }
            if(result) System.out.println(bf.toString());
        }
    }
}