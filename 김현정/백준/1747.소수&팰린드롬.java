package Main;
import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		
		n = (n == 1) ? 2 : n; 
		while(true) {
			if(isPanrindrom(String.valueOf(n))) {// 팬린드롬 검사
				// 소수 검사
				boolean flag = true;
				for(int i = 2; i <= Math.sqrt(n); i++ ) {
					if(n % i == 0) { // 소수 X
						flag = false;
						break;
					}
				}
				if(flag) {
					result = n;
					break;
				}
			}
			n++;
		}
		System.out.println(result);
		
	}
	
	public static boolean isPanrindrom(String n) {
		for(int i = 0; i < n.length() / 2; i++) {
			if(n.charAt(i) != n.charAt(n.length() - 1 - i)) return false;
		}
		return true;
	}
}