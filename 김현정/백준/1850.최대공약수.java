package Main;
import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		
		while(max % min != 0) {
			long temp = max % min;
			max = min;
			min = temp;
		}
		
		for(long i = 0; i < min; i++) {
			bw.write("1");
		}
		
		bw.close();
	}
}