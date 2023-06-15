package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11724 {
    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i<n+1; i++){
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i< m; i++){
            st1 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st1.nextToken());
            int e = Integer.parseInt(st1.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        int count = 0;

        for(int i = 1; i<n+1; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }

        System.out.println(count);

    }
    static void DFS(int i){
        if(visited[i]) return;

        visited[i] = true;
        for(int j: A[i]){
            if(!visited[j]){
                DFS(j);
            }
        }
    }

}
