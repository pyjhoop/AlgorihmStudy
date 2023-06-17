import java.util.Scanner;

public class Boj2750 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int A[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			int swap = 0;

			for(int j = 0; j < N - 1 - i; j++) {
				// 모든 자릿수에 대해 버블 정렬
				int temp = 0;
				
				if(A[j] > A[j+1]) {
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
					
					swap++;
				}
			}
			
			// swap이 한번도 일어나지 않으면 반복문 종료
			if(swap == 0) break;
		}
		
		for(int a: A) {
			System.out.println(a);
		}
	}
}
