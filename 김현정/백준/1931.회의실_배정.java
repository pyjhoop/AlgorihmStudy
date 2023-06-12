package Main;
import java.util.*;
import java.io.*;

/**
 * 아이디어가 중요한 문제
 * - greedy문제
 * - 끝나는 시간이 빠른 것을 선택, 끝나는 시간이 동일하면 시작 시간이 빠른 것을 선택.
 * - 선택한 것보다 시작시간이 크거나 같은 것을 선택 << 반복
 */
class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Conf[] arr = new Conf[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Conf(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		int end = 0;
		for(Conf x : arr) {
			if(end > x.start) continue;
			result++;
			end = x.end;
		}
		
		System.out.println(result);
	}
}

class Conf implements Comparable<Conf>{
	int start;
	int end;
	
	Conf(int s, int e){
		this.start = s;
		this.end = e;
	}
	
	@Override
	public int compareTo(Conf o) {
		if(this.end == o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}
}
