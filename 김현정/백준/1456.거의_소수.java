package Main;
import java.util.*;
import java.io.*;

/**
 * 반복 횟수 줄이기 & 공간 줄이기가 관건이던 문제
 * - 소수구하는 체 - 첫번째 for문에 Math.sqrt() 반드시 이용하기 
 * - 범위 넘긴다면 n * n < b 과 n < b / n 이 동일하다는것 이용해서 비교할 수 있다. 
 */
class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		int result = 0;
		
		long[] arr = new long[10000001]; // 최대 10^14가 되는 제곱근을 구하는 거라서 10^7까지만 구해도 됨
		
		// 소수 구하기(2 ~ 10^7 사이의 소수)
		a = (a == 1)? 2 : a;
		for(int i = 2; i <= Math.sqrt(arr.length); i++) { // 제일 큰 값인 10^7 sqrt 값보다 작은 수들의 전반 약수는 없음
			if(arr[i] == 1) continue;

			long mul = 2;
			long target = i * mul;
			while(target < arr.length) {
				arr[(int)target] = 1;
				target = i * (++ mul);
			}
		}
		
		// 거의 소수 구하기
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] == 0) {
				double div = i;
				while(i <= (b / div)) { // 그냥 비교하면 10^24까지 갈 수 있어서 overflow발생 ->  
					if((a / div) <= i)
						result++;
					div *= i;
				}
			}
		}
		
		System.out.println(result);
	}
}