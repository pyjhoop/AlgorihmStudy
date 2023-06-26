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
		
		// 진실 아는 사람 그룹핑
		int[] known= Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();	
		for(int i = 1; i <= known[0]; i++) {
			union(known[1], known[i]);
		}
		
		// 파티 정보 저장
		for(int i = 0; i < m; i++) {
			temp = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
			party[i] = temp;
		}

		// 파티 구성원 중 진실을 아는 사람 있으면 그룹핑
		for(int i = 0; i < m; i ++) {
			for(int j = 1; j < party[i][0]; j++) {
				if(known[0] != 0 && (find(party[i][j]) == known[1] || find(party[i][j + 1]) == known[1])) {
					union(known[1], party[i][j]);
					union(known[1], party[i][j + 1]);
				} else {
					union(party[i][j], party[i][j + 1]);
				}
			}
		}
		
		// 결과 구하기
		int answer = 0;
		for(int i =0; i < m; i ++) {
			boolean flag = true;
			for(int j = 1; j <= party[i][0]; j++) {
				if(known[0] != 0 && find(party[i][j]) == known[1]) {
					flag = false; break;
				}
			}
			if(flag) answer++;
		}
		
		System.out.println(answer);
	}
}

	
