package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex_11724 {
	/*
	 * 2023-06-22 DFS/BFS
	 * [BOJ]연결요소의 개수 / 실버2
	 * 
	 * 연결된 노드의 갯수를 출력하는 문제
	 * 
	 * [input] n: 노드갯수, k: 에지갯수 
	 * 6 5
	 * 1 2
	 * 2 5
	 * 5 1
	 * 3 4
	 * 4 6
	 * [output]
	 * 2
	 */
	static boolean[] visited;
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 노드 갯수
		int N = Integer.parseInt(st.nextToken());
		// 에지 갯수
		int M = Integer.parseInt(st.nextToken());
		
		// 방문 기록을 저장할 배열 생성
		visited = new boolean[N+1];
		
		// 각 연결된 노드를 기억할 리스트 생성
		A = new ArrayList[N+1];
		
		// 연결요소 변수
		int count = 0;
		
		for(int i = 1; i < N + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			A[u].add(v);
			A[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	static void dfs(int i) {
		// 이미 방문했으면
		if(visited[i]) return;
		
		visited[i] = true;
		
		for(int n: A[i]) {
			if(i == n) return;
			
			dfs(n);
		}
	}
}
