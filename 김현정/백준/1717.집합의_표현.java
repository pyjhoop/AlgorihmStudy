package Main;
import java.util.*;
import java.io.*;

class Main {
	static int[] arr;

	public static void union(int a, int b) {
		a = find(a); // 대표 노드로 변경
		b = find(b);
		if(a != b) arr[b] = a; 
	}
	
	public static int find(int v) {
		if(arr[v] == v) return v;
		else return arr[v] = find(arr[v]);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
							.mapToInt(Integer::parseInt)
							.toArray();
		
		arr = new int[input[0] + 1];
		for(int i = 1; i <= input[0]; i++) { // 초기화
			arr[i] = i;
		}
		
		for(int i = 0; i < input[1]; i++) {
			int[] temp= Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			
			if(temp[0] == 0) {
				union(arr[temp[1]], arr[temp[2]]);
			} else {
				if(find(arr[temp[1]]) == find(arr[temp[2]]))
						System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
}

	
