package Main;
import java.util.*;
import java.io.*;

class Main {
	static int num, m, n;
	static boolean[][] arr, checked;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		m = Integer.parseInt(s[0]); // row
		n = Integer.parseInt(s[1]); // col
		int k = Integer.parseInt(s[2]);
		
		arr = new boolean[m][n];
		checked = new boolean[m][n];
		for(int i = 0; i < k; i++) {
			s = br.readLine().split(" ");
			arr[Integer.parseInt(s[0]) - 1][Integer.parseInt(s[1]) - 1] = true;
		}
		
		int max = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] && !checked[i][j]) {
					num = 0;
					DFS(i, j);
					max = Math.max(max, num);
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static void DFS(int col, int row) {
		if(col < 0 || col >= m || row < 0 || row >= n || !arr[col][row] || checked[col][row]) {
			return;
		}
		num++;
		checked[col][row] = true;
		int[] x= {-1, 0, 1, 0};
		int[] y = {0, -1, 0, 1};
		for(int i = 0; i < 4; i++) {
			DFS(col + y[i], row + x[i]);
		}
	}
}
	
