import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023{
	/*
	 * 2023-06-22 DFS/BFS
	 * [BOJ] 친구 관계 파악하기 / 골드5
	 * 
	 * 서로 연결된 노드가 5개인지 여부 파악 (존재하면 1 존재하지않으면 0반환)
	 * 
	 * [input] N: 노드갯수, M: 에지갯수 
	 * 5 4
	 * 0 1
	 * 1 2
	 * 2 3
	 * 3 4
	 * 
	 * [output]
	 * 1
	 */
	static boolean[] visited;
	static ArrayList<Integer>[] A;
	static boolean arrive = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 노드 갯수
		int N = Integer.parseInt(st.nextToken());
		// 에지 갯수
		int M = Integer.parseInt(st.nextToken());
		
		// 방문 기록을 저장할 배열 생성
		visited = new boolean[N];
		
		// 각 연결된 노드를 기억할 리스트 생성
		A = new ArrayList[N];
				
		for(int i = 0; i < N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			A[u].add(v);
			A[v].add(u);
		}
		
		// 변수 초기화 작업 끝
		
		// 노드의 갯수만큼 반복
		for(int i = 0; i < N; i++) {
			dfs(i, 1);
			
			// depth가 5일 때까지 탐색되었으면 break
			if(arrive) {
				break;
			}
		}
		
		// arrive가 true면 1, false면 0 반환
		System.out.println(arrive ? 1 : 0);
	}
	
	static void dfs(int n, int depth) {
		// 길이가 5일 때까지 탐색되었다면 재귀함수 종료
		if(depth == 5 || arrive) {
			arrive = true;
			return;
		}
		
		// 방문 여부 true처리
		visited[n] = true;
		
		// 현재 노드와 연결된 노드 순회
		for(int i : A[n]) {
			// 방문하지 않은 노드라면 탐색 진행
			if(!visited[i]) {
				dfs(i, depth + 1);
			}
		}
		
		// depth가 5까지 도달하지 못하고 탐색 종료될 경우
		// 방문 여부 false처리
		visited[n] = false;
	}
}
