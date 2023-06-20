import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 도시 수
		int m = Integer.parseInt(st.nextToken()); // 도로 개수
		int k = Integer.parseInt(st.nextToken()); // 찾으려는 거리 정보
		int x = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		
		List<List<Integer>> graph = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) graph.add(new LinkedList<>());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}
		
		// BFS
		boolean[] checked = new boolean[n + 1];
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int cnt = 0;
		
		checked[x] = true;
		q.add(x);
		while(!q.isEmpty() && cnt < k) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int target = q.poll();
				graph.get(target).forEach(j -> {
					if(!checked[j]) {
						checked[j] = true;
						q.add(j);
					}
				});
			}
			cnt ++;
		}
		
		if(!q.isEmpty()) {
			while(!q.isEmpty()) {
				System.out.println(q.poll());
			}
		} else {
			System.out.print(-1);
		}
	}

}