package Main;
import java.util.*;
import java.io.*;

/**
 * 위상정렬
 * : '이것 앞에만 오면 돼' 조건의 정렬
 * 
 * 1 -> 3
 * 2 -> 3 일 경우
 * => 1, 2, 3/ 2, 1. 3  둘 다 가능
 */
class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] students = new int[n + 1];
		List<Integer>[] graph = new LinkedList[n + 1];

		for(int i = 0; i <= n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			students[b]++;
		}
		
		List<Integer> answer = new LinkedList<>();
		while(true) {
			int target = 0;
			for(int i = 1; i <= n; i++) {
				if(students[i] == 0) {
					target = i;
					answer.add(target);
					students[target] = -1;
					break;
				}
			}
			if(target == 0) break;

			graph[target].forEach(x -> {
				students[x]--;
			});
		}
		
		answer.forEach(x -> System.out.print(x + " "));
	}
}

	
