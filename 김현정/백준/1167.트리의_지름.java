package Main;
import java.io.*;
import java.util.*;

/**
 * DFS로든 BFS로든 풀 수 있는 문제
 * 핵심 : 임이의 노드에서 가장 긴 경로로 연결된 노드는 트리의 지름에 해당하는 두 노드 중 하나이다.
 * => 즉, 2번 해야한다는 아이디어를 떠올릴 수 있는가 가 판가름
 */
public class Main {
	static boolean[] check;
	static int[] edges;
	static int max;
	static List<List<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		edges = new int[n + 1];
		check = new boolean[n + 1];
		for(int i = 0; i<=n; i++) {
			list.add(new LinkedList<>());
		}
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			while(b != -1) {
				int c = Integer.parseInt(st.nextToken());
				
				list.get(a).add(new Node(b, c));
				b = Integer.parseInt(st.nextToken());
			}
		}
		
		// BFS로 임이의 노드에서 시작했을 때 가장 긴 길이를 가진 노드 찾기
		for(int i = 1; i<=n; i++) {
			if(!check[i]) {
				BFS(i);
			}
		}
		
		Arrays.fill(check, false);
		Arrays.fill(edges, 0);

		// 길었던 노드에서 BFS 시작해서 최종 길이 찾기.
		BFS(max);
		System.out.println(edges[max]);
	}
	
	public static void BFS(int start) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start, 0));
		check[start] = true;
		while(!q.isEmpty()) {
			Node target = q.poll();
			for(Node x : list.get(target.v)) {
				if(!check[x.v]){
					check[x.v] = true;
					edges[x.v] = edges[target.v] + x.e;
					max = (edges[x.v] > edges[max])? x.v : max;
					q.add(x);
				}
			}
		}
	}
}


class Node {
	int v;
	int e;
	
	Node(int v, int e){
		this.v = v;
		this.e = e;
	}
}

