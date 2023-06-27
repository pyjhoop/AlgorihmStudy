package Main;
import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] graph = new LinkedList[n + 1];
		int[] time = new int[n + 1];
		int[] check = new int[n + 1];
		
		for(int i = 0; i <= n; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i = 1; i <= n; i++) {
			int[] temp = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			time[i] = temp[0];

			int idx = 1;
			while(temp[idx] != -1) {
				graph[temp[idx++]].add(i);
				check[i]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= n; i ++) {
			if(check[i] == 0) {
				q.offer(i);
			}
		}
		
		int[] answer = new int[n + 1];
		while(!q.isEmpty()) {
			int target = q.poll();
			
			graph[target].forEach(x -> {
				check[x]--;
				if(check[x] == 0) {
					q.offer(x);
				}
				
				answer[x] = Math.max(answer[x], time[target] + answer[target]);
			});
		}
		
		for(int i= 1; i <= n; i++) {
			System.out.println(time[i] + answer[i]);
		}
	}
}

	


