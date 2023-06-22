package Main;
import java.util.*;
import java.io.*;

class Main {
	static int[] check;
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) check[b] = a;
	}
	
	public static int find(int v) {
		if(check[v] == v) return v;
		return check[v] = find(check[v]);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		check = new int[n];
		for(int i = 0; i < n; i++) check[i] = i;
		
		for(int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				if(j >= i) break;
				if(temp[j].equals("1")) union(i, j);
			}
		}
		
		int[] schedule = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		
		boolean flag = true;
		int head = find(schedule[0] - 1);
		for(int x : schedule) {
			if(head != find(x - 1)) flag = false;
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
}

	
