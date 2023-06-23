import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	/*
	 * 2023-06-20
	 * 스택/큐
	 * 백준 요세푸스 문제 0 / 실버5
	 * 
	 * N은 1부터 N까지의 수를 의미합니다. 
	 * K는 자릿수를 의미합니다.
	 * 
	 * K번째 숫자로 순열을 만들어 반환합니다.
	 * 
	 * 7 3
	 * <3, 6, 2, 7, 5, 1, 4>
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue q = new LinkedList();
		
		String answer = "<";
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}

		while(true) {
			// 자릿수마다 결과 문자열에 추가
			// 해당 자릿수가 나오기 전까지 가장 앞 요소를 가장 마지막 위치로 옮겨준다.
			for(int i = 1; i <= K; i++) {
				if(i == K) {
					answer += q.poll() + ", ";
				} else {
					q.offer(q.poll());
					
				}
			}
			if(q.isEmpty()) break;
		}
		
		System.out.println(answer.substring(0, answer.length()-2) + ">");
	}
}
