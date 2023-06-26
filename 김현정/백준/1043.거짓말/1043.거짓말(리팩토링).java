package Main;
import java.util.*;
import java.io.*;

class Main {
	static int[] grouping;
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) grouping[b] = a;
	}
	
	public static int find(int v) {
		if(v == grouping[v]) return v;
		else return grouping[v] = find(grouping[v]);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] temp = Arrays.stream(br.readLine().split(" "))
		.mapToInt(Integer::parseInt).toArray();
		
		int n = temp[0];
		int m = temp[1];
		
		grouping = new int[n + 1];
		int[][] party = new int[m][];

		// 그룹 초기화
		for(int i = 0; i <= n; i ++) {
			grouping[i] = i;
		}
		
		int[] known= Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();	
		
		// 같은 파티 간 사람끼리 그룹핑
		for(int i = 0; i < m; i++) {
			temp = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
			
			party[i] = temp;
			for(int j = 1; j <= temp[0]; j++) {
				union(temp[1], temp[j]); // 파티의 대표 노드로 
			}
		}
		
		// 진실 아는 사람 그룹핑
		for(int i= 2; i <= known[0]; i++) {
			union(known[1], known[i]); // 대표 노드로
		}
		
		int answer = 0;
		for(int i = 0; i < m; i++) {
			if(known[0] == 0 || find(party[i][1]) != find(known[1])) answer++;
		}
		
		System.out.println(answer);
	}
}

	
