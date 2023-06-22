package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2606 {

    static boolean visit[];
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visit = new boolean[n+1];

        arr = new ArrayList[n+1];

        for(int i = 1;i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            arr[e].add(s);
            arr[s].add(e);
        }

        DFS(1);

        int count = 0;

        for(boolean b: visit){
            if(b){
                count++;
            }
        }

        System.out.println(count-1);

    }

    static void DFS(int node){
        if(visit[node]){
            return;
        }

        visit[node] = true;

        for(int i: arr[node]){
            DFS(i);
        }

    }
}
