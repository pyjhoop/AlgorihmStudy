import java.io.*;
import java.util.*;

class Dot {
	int x;
	int y;
	
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(temp.substring(j, j+1));
			}
		}
		
		int result = 0;
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(0, 0));
		arr[0][0] = 0;
		
		int[] x_idx = {-1, 0, 1, 0};
		int[] y_idx = {0, 1, 0, -1};
		boolean flag = true;
		
		while(!q.isEmpty() && flag) {
			result++;
			int len = q.size();
			for (int j = 0; j < len; j++) {
				Dot t = q.poll();
				if(t.x == n - 1 && t.y == m - 1) {
					flag = false;
					break;
				}
				
				for(int i = 0; i<4; i++) {
					int x = t.x + x_idx[i];
					int y = t.y + y_idx[i];
					
					if(x >= 0 && y >= 0 && x < n && y < m && arr[x][y] == 1) {
						arr[x][y] = 0;
						q.add(new Dot(x, y));
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
