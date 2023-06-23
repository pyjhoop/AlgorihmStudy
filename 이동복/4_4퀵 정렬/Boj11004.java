import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj11004 {

	public static void main(String[] args) throws IOException {
//		5 2
//		4 1 2 3 5
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		// 숫자 갯수
		int N = Integer.parseInt(st.nextToken());
		// 찾아야 할 위치
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		
		// 배열 초기화
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(A, 0, N-1, K-1);
		System.out.println(A[K -1]);
	}
	
	// 부분집합 만들기 함수
	public static void quickSort(int[] A, int S, int E, int K) {
		if(S < E) {
			int pivot = partition(A, S, E);
			
			if (pivot == K) {
				return;
			} else if(pivot < K) {
				quickSort(A, 0, pivot - 1, K);
			} else {
				quickSort(A, pivot + 1, E, K);
			}
		}
	}; 
	
	// 부분집합 만들기 함수
	public static int partition(int[] A, int S, int E) {
		if(S + 1 == E) {
			if(A[S] > A[E]) swap(A, S, E);
			return E;
		}
		
		int M = (S + E) / 2;
		
		swap(A, S, M);
		
		int pivot = A[S];
		int i = S + 1, j = E;
		
		while(i <= j) {
			while(A[S] < A[j] && j > 0) {
				j--;
			} 
			
			while(A[S] > A[i] && i < E - 1) {
				i++;
			}
			
			if(i <= j) {
				swap(A, i++, j--);
			}
		}
		
		A[S] = A[j];
		A[j] = pivot;
		
		return j;
	}
	
	// 요소 값 서로 바꾸기 함수
	public static void swap(int[] A, int S, int E) {
		int temp = A[S];
		A[S] = A[E];
		A[E] = temp;
	}
}
