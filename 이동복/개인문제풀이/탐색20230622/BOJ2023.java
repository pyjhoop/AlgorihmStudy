package boj;

import java.util.Scanner;

public class BOJ2023{
	/*
	 * 2023-06-22 DFS/BFS
	 * [BOJ]신기한 소수찾기 / 골드5
	 * 
	 * 자릿수가 주어지고 좌측부터 1,2,3 .. n자릿수가 모두 소수인 숫자 출력
	 * 
	 * [input]
	 * 4

	 * [output]
	 * 2333
	 * ...
	 * 7393
	 * 
	 */
	
	static int n;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 1의 자릿수가 소수인 경우 탐색 시작
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}
	
	static void dfs(int targetN, int digit) {
		// 자릿수가 n과 같을 때 소수라면 출력
		if(digit == n) {
			if(isPrime(targetN)) System.out.println(targetN);
			return;
		}
		
		// 다음 자릿수가 홀수일 때 합성수가 소수인지 판별
		for(int i = 1; i < 10; i++) {
			if(i % 2 == 0) continue;
			
			int newNumber = targetN * 10 + i;
			
			// 합성수가 소수라면 자릿수를 1 증가시키고 탐색 진행
			if(isPrime(newNumber)) {
				dfs(newNumber, digit + 1);
			}
		}
	}
	
	// 소수인지 판별하는 함수
	static boolean isPrime(int number) {
		for(int i = 2; i <= number / 2; i++) {
			if(number % i == 0) return false;
		}
		
		return true;
	}
}
