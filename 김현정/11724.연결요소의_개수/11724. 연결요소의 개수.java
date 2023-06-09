package Main;
import java.io.*;
import java.util.*;

/**
 * DFS문제
 * - 양방향 그래프 탐색 
 */
public class Main {
	static List<List<Integer>> list = new ArrayList<>();
	static int[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 그래프 생성
		for(int i = 0; i <= n; i++) { // node는 1부터 시작이라 n포함
			list.add(new LinkedList<>());
		}

		// 입력값 list에 세팅
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a); // 문제에 방향 얘기가 없으면 양방향.
		}
		
		check = new int[n + 1]; // node는 1부터 시작이라 
		int count = 0;
		for(int i = 1; i <= n; i++) {
			if(check[i] != 1) {
				count++;
				check[i] = 1;
				DFS(i);
			}
		}
		
		bw.write(String.valueOf(count));
		bw.close();
	}
	
	public static void DFS(int target) {
		
		list.get(target).forEach(i -> {
			if(check[i] != 1) {
				check[i] = 1;
				DFS(i);
			}
		});
	}
}