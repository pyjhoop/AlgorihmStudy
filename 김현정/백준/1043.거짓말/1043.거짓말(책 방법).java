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
		
		
		// 파티에 진실 아는 사람과 같은 그룹인 사람 있으면 count X
		int answer = 0;
		for(int i = 0; i < m; i++) {
			boolean flag = true;
			for(int j = 1; j <= known[0]; j++) {
				if(find(party[i][1]) == find(known[j])) {
					flag = false; break;
				}
			}
			if(flag) answer++;
		}
		
		System.out.println(answer);
	}
}

	
