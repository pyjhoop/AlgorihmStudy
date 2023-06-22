import java.util.*;

import java.io.*;

class Main {
	static int n, m;
	static List<Integer> graph[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n + 1];
		for(int i= 0; i<=n; i++) graph[i] = new ArrayList<>();
		
		for(int i = 0; i<m; i++) {
			 st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b].add(a);
		}
		
		int[] hacking = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			hacking[i] = BFS(i);
		}
		int max = Arrays.stream(hacking).max().getAsInt();

		for(int i = 1; i <= n; i++) {
			if(max == hacking[i]) bw.write(i + " ");
		}
		bw.close();
	}
	public static int BFS(int start) {
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		int result = 0;
		while(!q.isEmpty()) {
			int target = q.poll();
			for(int x : graph[target]) {
				if(!visited[x]) {
					visited[x] = true;
					q.add(x);
					result++;
				}
			};
		}
		return result;
	}

}