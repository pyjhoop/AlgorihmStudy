package Main;
import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		
		boolean[] check = new boolean[(int) (max - min + 1)]; // true = 제곱수, false = 제곱수 ㄴㄴ(찾으려는 값)

		// 에라토스체네스의 체 방식 적용
		for(long i = 2; i  <= Math.sqrt(max); i++) {
			long pow = i * i; // 제곱수
			long start = min % pow == 0 ? min / pow : min / pow + 1;
			
			for(int j = (int)start; j * pow <= max; j++) { // 제곱근 * 제곱근 = 제곱근 이니 에리스토체로 검사
				check[(int)(j * pow - min)] = true;
			}
		}
		
		int count = 0;
		for(int i = 0; i < check.length; i++) {
			if(!check[i]) count++;
		}
		
		System.out.println(count);
	}
}