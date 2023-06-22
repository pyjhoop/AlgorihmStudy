package Main;
import java.util.*;
import java.io.*;

class Main {
	static int n, m, num;
	static String[] arr;
	static boolean[][] checked;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		arr = new String[m];
		checked = new boolean[m][n];
		for(int i = 0; i<m; i++) {
			arr[i] = br.readLine();
		}
		
		int sumW = 0, sumB = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!checked[i][j]) {
					num = 0;
					DFS(i, j, arr[i].charAt(j));
					switch(arr[i].charAt(j)) {
					case 'W': sumW += num * num; break;
					case 'B': sumB += num * num;
					}
				}
			}
		}
		
		System.out.println(sumW + " " + sumB);
	}
	
	public static void DFS(int col, int row, char before) {
		if(col < 0 || row < 0 || col >= m || row >= n || checked[col][row]|| before != arr[col].charAt(row)) {
			return;
		}
		
		num++;
		checked[col][row] = true;
		int[] x = {-1, 0, 1, 0};
		int[] y = {0, -1, 0, 1};
		
		for(int i = 0; i < 4; i++) {
			DFS(col + y[i], row + x[i], arr[col].charAt(row));
		}
	}
}
	
