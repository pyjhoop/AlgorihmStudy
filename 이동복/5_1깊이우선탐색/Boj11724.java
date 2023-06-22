import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11724 {
	static ArrayList<Integer> A[] = null;
	static boolean[] check = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		

		int count = 0;
		check = new boolean[n + 1];
		A = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());;
			
			int u = Integer.parseInt(st.nextToken()); 
			int v = Integer.parseInt(st.nextToken()); 
			
			A[u].add(v);
			A[v].add(u);
		}
		
		for(int i = 1; i <= n; i++) {
			if(!check[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println("count= " + count);
	}
	
	static void dfs(int i) {
		if(check[i]) {
			return;
		}
		
		check[i] = true;
		
		for(int n: A[i]) {
			if(check[n] == false) {
				dfs(n);
			}
		}
	}
}
