package Main;
import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int max = Math.max(a, b);
			int min = Math.min(a ,b); 
			while(max % min != 0) {
				int temp = max % min;
				max = min;
				min = temp;
			}
			
			System.out.println(a * b / min);
		}
	}
}