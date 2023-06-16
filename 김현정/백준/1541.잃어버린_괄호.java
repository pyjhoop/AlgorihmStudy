package Main;
import java.util.*;
import java.io.*;

/**
 * 문자열 & 파싱 으로 품
 * - 음수(-) 뒤의 양수(+)는 모두 음수 처리해주면 최소 값이 된다.
 */
class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringTokenizer minus = new StringTokenizer(sc.nextLine(), "-", true);
		int result = 0;
		boolean isMinus = false;
		while(minus.hasMoreTokens()) {
			String temp = minus.nextToken();
			if(temp.equals("-")) {
				isMinus = true;
				continue;
			}
			
			StringTokenizer plus = new StringTokenizer(temp, "+");
			int num = 0;
			while(plus.hasMoreTokens()) {
				num += Integer.parseInt(plus.nextToken());
			}
			result += (isMinus)? -num : num;
			isMinus = false;
		}
		
		System.out.println(result);
	}
}

