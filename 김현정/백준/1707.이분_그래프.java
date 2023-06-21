/** 문제 조건 찾기가 너무 어려움
 * 1. 단방향이고 이미 방문한 노드에 다시 돌아갔을 때를 찾는 줄 알았다.
 *  => 첫번째 예제처럼 역방향으로 노드에 돌아가도 이분 그래프가 될 수 있다.
 * 2. 양방향 그래프에 사이클이 발생했을 때를 찾는 줄 알았다.
 * 3. 단뱡향 그래프에 사이클이 발생했을 떄 찾는 줄 알음
 *  => 사이클 찾는 문제가 아님. 같은 그룹이면 역방향 생성되도 된다.
 *  => ex) 1 ->2, 2 ->1 : 이분그래프이다.
 * 4. 결국 두 개의 그룹으로 나눠서 같은 그룹끼리 연결된 것이 없도록 해줘야 한다.
 *  => 단순하게 인접 그래프에서 딸린 노드들이 전부 다른 그룹이라면 이분 그래프란 것
 */

package Main;
import java.util.*;
import java.io.*;


class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // testCase
		
		while (t-- > 0) {
			int n = sc.nextInt(); // 정점의 수
			int m = sc.nextInt(); // 간선의 수

			List<Integer>[] a = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				a[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				a[x].add(y); // 양방향 그래프로 세팅
				a[y].add(x);
			}

			
			int[] color = new int[n + 1]; // 정점의 방문 여부
			// 0 : 방문 X, 1 : part1 소속 방문O , 2: part2 소속 방문O
			boolean ok = true;

			for (int i = 1; i <= n; i++) {
				if (color[i] == 0) // 정점 i 방문 X인 상태라면,
					dfs(a, color, i, 1);
			}

			for (int i = 1; i <= n; i++) {
				for (int j : a[i]) { // i가 정점, j가 딸린 것들
					if (color[i] == color[j]) { //정점에 연결된 것에 다른 같은 그룹인 것이 있다면
						ok = false; // 이분 그래프가 아니다.
					}
				}
			}
			if (ok) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	// c는 그룹을 나누기 위한 변수
	public static void dfs(List<Integer>[] a, int[] color, int x, int c) {
		color[x] = c;
		for (int y : a[x]) {
			if (color[y] == 0) {
				dfs(a, color, y, 3 - c); // 그룹이 1이면 2, 2면 1이 되도록
			}
		}
	}
}