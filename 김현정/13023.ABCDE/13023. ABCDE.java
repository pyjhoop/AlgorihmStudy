package Main;
import java.io.*;
import java.util.*;

/**
 * 전형적인 DFS 문제 
 */
public class Main {
	static boolean flag = false; 
	static int[] check;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		check = new int[n];
		
		for(int i = 0; i<n; i++) {
			list.add(new LinkedList<>());
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 0; i<n; i++) {
			if(flag) break;
			DFS(i, 0);
		}
		
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
	
	public static void DFS(int t, int cnt) {
		if(cnt == 5) { // 5명 이상 연결될 때를 찾는 문제라서
			flag = true;
			return;
		}
		
		list.get(t).forEach(j -> {
			if(check[j] != 1 && !flag) {
				check[j] = 1;
				DFS(j, cnt+1);
				check[j] = 0;
			}
		});
		
		return;
	}
}
