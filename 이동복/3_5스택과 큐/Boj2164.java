import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2164 {

	public static void main(String[] args) {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
	        printLastCard(n);
		}
	    
	    static void printLastCard(int n) {
	        Queue<Integer> q = new LinkedList<Integer>();
	        
	        if(n == 1) {
	            System.out.println(1);
	            return;
	        }
	        
			for(int i = 1; i <= n; i++) {
				q.add(i);
			}
			
			while(q.size() > 1) {
				// 1. 가장 먼저 들어온 요소 빼기
				q.poll();
				// 2. 가장 먼저 들어온 요소 맨 뒤로 보내기
				q.add(q.poll());
	        }
	        
	         System.out.println(q.poll());       
	         return;
	    }

}
