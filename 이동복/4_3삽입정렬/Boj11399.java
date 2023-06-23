import java.util.Arrays;
import java.util.Scanner;

public class Boj11399 {

	public static void main(String[] args) {
//		5
//		3 1 4 3 2
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String[] inputNums = sc.nextLine().split(" ");
		
		int[] A = new int[n];
		int[] S = new int[n];
		
		// 배열 초기화
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(inputNums[i]);
		}
		
		// 1 ~ N
		for(int i = 1; i < n; i++) {
			// 선택된 값
			int insert_value = A[i];
			// 선택된 값이 들어갈 index
			int insert_point = i;
			
			// i - 1 ~ 0
			for(int j = i - 1; j >= 0; j--) {
				// 선택된 값이 이전 요소보다 크면
				if(A[i] > A[j]) {
					insert_point = j + 1;
					break;
				}
				
				if(j == 0) {
					insert_point = 0;
				}
			}
			
			// 선택된 index부터 shift될 범위
			for(int j = i; j > insert_point; j--) {
				A[j] = A[j-1];
			}
			
			// 삽입될 index에 지정된 값 할당
			A[insert_point] = insert_value;
		}
		
		// 합배열 초기화
		S[0] = A[0];
		
		for(int i = 1; i < n; i++) {
			S[i] = S[i-1] + A[i];
		}
		
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			sum += S[i];
		}
		
		System.out.println(sum);
	}
}
