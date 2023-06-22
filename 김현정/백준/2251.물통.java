package Main;
import java.util.*;
import java.io.*;

class Main {
	static int[] sender = {0, 0, 1, 1, 2, 2}; // A -> {B, C}, B -> {A,C}
	static int[] receiver = {1, 2, 0, 2, 0, 1};
	static boolean[][] visited;
	static int[] now;
	static List<Integer> answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		now = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		
		visited = new boolean[201][201];
		answer = new LinkedList<>();
		
		BFS();
		
		Collections.sort(answer); // 중복값은 들어가지 않음. visited로 C값도 같이 조절됨.
		
		for(int x: answer) {
			System.out.print(x + " ");
		}
	}

	public static void BFS() {
		Queue<AB> queue = new LinkedList<>();
		queue.add(new AB(0, 0));
		visited[0][0] = true;
		answer.add(now[2]);
		
		while(!queue.isEmpty()) {
			AB p = queue.poll();
			int a = p.a;
			int b = p.b;
			int c = now[2] - a - b;
		
			for(int k = 0; k < 6; k++) {
				int[] next = {a, b, c}; // 다음 전달할 값 초기값(현재값).
				next[receiver[k]] += next[sender[k]];
				next[sender[k]] = 0;
				
				if(next[receiver[k]] > now[receiver[k]]) { // 물이 넘칠 때
					// 초과하는 만큼 원상복귀
					next[sender[k]] = next[receiver[k]] - now[receiver[k]];
					next[receiver[k]] = now[receiver[k]]; // 그 병의 최대값
				}
				
				if(!visited[next[0]][next[1]]) {// 방문한 적 없다면
					visited[next[0]][next[1]] = true;
					queue.add(new AB(next[0], next[1]));
					if(next[0] == 0) answer.add(next[2]);
				}
			}
		}
	}
}

class AB{
	int a;
	int b;
	
	AB(int a, int b){
		this.a = a; this.b = b;
	}
}
	
