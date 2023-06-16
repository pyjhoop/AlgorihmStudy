package Main;
import java.util.*;
import java.io.*;

/**
 * <문제 푸는 원리>
 * 4a : 10b = p : q 일 때
 * b = 10 * p;    a = 4 * q;
 * (이 때 최소값이므로 4와 10, p와 q 쌍을 각각 최소공약수로 나눈다. << 틀림
 *   => 4와 10 위치의 값이 서로 서로소여도, 
 *   	4와 p가 서로소가 아닐 수 있기에 여기서 최소공약수 구하며 소용 X)
 * 이 떄 최소값이므로 p와 q의 쌍을 최소공약수로 나누고
 * 완성된 a와 b의 쌍의 최소공약수로 a, b 각각을 다시 나눈다.
 * 
 * 완성된 a와 b를 기존의 값에 곱해서 업데이트, 관련된 것에도 전파한다. 
 */
class Node {
	int val = 1;
	List<Integer> relative = new ArrayList<>();
	
}
class Main {
	static int[] check;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Node[] arr = new Node[n];
		check = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = new Node();
		}
		
		for(int i = 0; i < n-1; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			int p = sc.nextInt(), q = sc.nextInt();
			
			int pqgnd = gnd(p, q); // 비율의 최대공약수 구하기
			int a_mul = arr[b].val * p / pqgnd;
			int b_mul = arr[a].val * q / pqgnd;
			
			int mulgnd = gnd(a_mul, b_mul);
			
			update(arr, a, a_mul / mulgnd);
			update(arr, b, b_mul / mulgnd);
			
			arr[a].relative.add(b);
			arr[b].relative.add(a);
		}
		
		for(Node x : arr) {
			System.out.print(x.val + " ");
		}
	}
	
	public static int gnd(int p, int q) {
		int max = Math.max(p, q);
		int min = Math.min(p, q);
		while(max % min != 0) {
			int temp = max % min;
			max = min;
			min = temp;
		}
		return min;
	}
	
	public static void update(Node[] arr, int target, int mul) {
		if(check[target] == 1) return;
		check[target] = 1;
		arr[target].val *= mul;
		arr[target].relative.forEach(t -> {
//			arr[node].val *= mul;
			update(arr, t, mul);
		});
		check[target] = 0;
	}
}