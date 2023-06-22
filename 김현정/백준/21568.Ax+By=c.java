package Main;
import java.util.*;
import java.io.*;

class Node {
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a= Integer.parseInt(st.nextToken());
		int b= Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		long result = -1;
		
		// 최소값 c 구하기
		int min_c = gcd(Math.max(a, b), Math.min(a, b));
		// 정수가 가능한지 확인
		if(c % min_c != 0) {
			System.out.println(result);
			return;
		}
		
		// x, y 구하기
		Node node = returnAB(a, b);
		int k = c / min_c;
		System.out.println(node.x * k + " " + node.y * k);
	}
	
	public static int gcd(int max, int min) {
		if(min == 0) return max;
		return gcd(min, max % min);
	}
	
	public static Node returnAB(int a, int b) {
		if(b == 0) {
			return new Node(1, 0);
		}
		
		Node node = returnAB(b, a % b);
		return new Node(node.y, node.x - node.y * (a / b));
	}
}