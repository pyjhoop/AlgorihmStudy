package Main;
import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> list = new ArrayList<>();
	static int[] check;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		check = new int[n + 1];
		
		for(int i = 0; i<=n; i++) {
			list.add(new LinkedList<>());
		}
		
		// 입력값 세팅
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		// 문제조건: 작은 순으로 정렬
		for(int i = 1; i<=n; i++) {
			Collections.sort(list.get(i));
		}
		
		DFS(v); // DFS
		
		// check배열 초기화 + enter출력
		System.out.println();
		Arrays.fill(check, 0);
		
		BFS(v); // BFS
	}
	
	public static void DFS(int v) {
		check[v] = 1;
		System.out.print(v + " ");

		list.get(v).forEach(i ->{
			if(check[i] != 1) {
				DFS(i);
			}
		});
	}

	public static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		check[v] = 1;
		
		while(!q.isEmpty()) {
			int t = q.poll();
			System.out.print(t + " ");
			list.get(t).forEach(i -> {
				if(check[i] != 1) {
					check[i] = 1;
					q.add(i);
				}
			});
		}
	}
}
