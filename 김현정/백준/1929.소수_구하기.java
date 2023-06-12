package Main;
import java.util.*;
import java.io.*;


class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		m = (m == 1)? 2 : m;
		int[] arr = new int[n + 1];

		for(int i = 2; i <= Math.sqrt(n); i++) { // N의 약수는 N의 제곱근보다 클 수 없다.
			int mul = 2;
			int target = i * mul;
			while(target <= n) {
				arr[target] = 1;
				target = i * (++mul);
			}
		}
		
		for(int i = m; i < arr.length; i++) {
			if(arr[i] == 0)
				sb.append(i + "\n");
		}

		bw.write(sb.toString());
		bw.close();
	}
}