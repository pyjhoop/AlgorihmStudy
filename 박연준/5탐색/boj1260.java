package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1260 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];

        for(int i = 1; i< n+1; i++){
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            A[s].add(p);
            A[p].add(s);
        }

        for(int i =1; i<=n; i++){
            Collections.sort(A[i]);
        }

        visited = new boolean[n+1];
        DFS(v);


    }

    public static void DFS(int start){
        System.out.print(start+" ");

        visited[start] = true;
        for(int i: A[start]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int nowNode = queue.poll();
            System.out.print(nowNode+" ");

            for(int i: A[nowNode]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }


}
