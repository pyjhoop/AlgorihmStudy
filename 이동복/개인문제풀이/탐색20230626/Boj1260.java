package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1260 {
	/*
	 * 2023-06-26 DFS/BFS
	 * [BOJ] DFS와 BFS / 실버2
	 * 
	 * dfs, bfs로 각각 결과를 출력하라
	 * 
	 * [input]
	 * 
	 * 노드 갯수 n
	 * 엣지 m
	 * 시작 노드 v
	 * 4 5 1
	 * 1 2
	 * 1 3
	 * 1 4
	 * 2 4
	 * 3 4
	 * 
	 * [output]
	 * 1 2 4 3
	 * 1 2 3 4
	 * 
	 */
	
	// 방문 노드 체크 배열
	static boolean[] visited;
	
	// 각 노드의 연결을 나타내는 배열
	static ArrayList<Integer>[] A;
	
	static String answerDFS = "";
	static String answerBFS = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 노드 갯수
		int n = Integer.parseInt(st.nextToken());
		// 엣지 갯수
		int m = Integer.parseInt(st.nextToken());
		// 시작 노드
		int v = Integer.parseInt(st.nextToken());
		
		// 각 변수 초기화
		visited = new boolean[n + 1];
		
		A = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);
			A[e].add(s);
		}
		
		// 연결 노드 오름차순 정렬
		for(int i = 1; i <= n; i++) {
			Collections.sort(A[i]);
		}
		
		// dfs 탐색 시작 함수 호출
		dfs(v);
		
		// 방문 여부를 false로 초기화
		Arrays.fill(visited, false);
		
		// bfs 탐색 시작 함수 호출
		bfs(v, n);
		
		// 정답 출력
		System.out.println(answerDFS.trim());
		System.out.println(answerBFS.trim());
	}
	
	static void bfs(int start, int nodeNum) {
		// 탐색 완료된 노드를 저장할 리스트
		List<Integer> finishList = new ArrayList<>();
		// 탐색 순 노드를 저장할 큐
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 최초의 노드를 큐에 넣어준다.
		q.offer(start);
		
		// 탐색이 끝난 노드의 갯수와 처음 주어진 노드의 갯수가 일치하면 종료 
		while(finishList.size() != nodeNum) {
			
			// 큐가 비어있다면 종료
			if(q.isEmpty()) {
				break;
			}
			
			// 큐에 담긴 노드를 꺼낸다.
			int getNum = q.poll(); 
			
			// 탐색 노드 방문 체크
			if(visited[getNum]) {
				continue;
			}
			
			// 탐색 노드 방문 완료 처리
			visited[getNum] = true;
			
			// 탐색 완료 리스트에 노드 추가
			finishList.add(getNum);
			answerBFS += getNum + " ";
			
			// 해당 노드의 인접 노드를 전부 큐에 추가
			// 단, 방문하지 않은 노드만
			for(int i : A[getNum]) {
				if(!visited[i]) q.offer(i);
			}
		}
		return;
	}
	
	static void dfs(int start) {

		// 탐색 노드 방문 여부 체크
		if(visited[start]) {
			return;
		}
		
		// 탐색 노드 방문 처리
		visited[start] = true;
		answerDFS += start + " ";
		
		// 현재 탐색 노드와 연결된 노드로 탐색을 이어간다.
		for(int i : A[start]) {
			dfs(i);
		}
	}

}
