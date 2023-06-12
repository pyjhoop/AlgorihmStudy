package Main;
import java.io.*;
import java.util.*;


/**
 * 소수 검사
 * - N의 절반까지만 검사해도 된다. nlog(n)
 */
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		DFS(n, 2);
		DFS(n, 3);// 첫 자리수 따로 구해야하는 이유 => 첫 자리는 1이 올 수 없는데 뒷 자리는 1이 가능하다.
		DFS(n, 5);
		DFS(n, 7);
	}
	
	public static void DFS(int n, int k) {
		if(k >= Math.pow(10, n-1)) {
			System.out.println(k);
			return;
		}
		
		for(int i = 1; i <= 9; i++) {
			if(i % 2 != 0 && isPrimeNumber((k * 10) + i)) { // 짝수는 소수X && 해당 수가 소수인지
				DFS(n, (k * 10) + i); // 소수라면 다음 검사
			}
		}
	}
	
	public static boolean isPrimeNumber(int k) { // 소수인가?
		for(int i = 2; i < k/2; i++) {
			if(k%i == 0) return false;
		}
		return true;
	}
}
