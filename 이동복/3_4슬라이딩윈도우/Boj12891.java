import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Boj12891 {
	// 각 문자가 충족해야 하는 값
	static int checkArr[]; 
	// 현재 부분 문자열의 각 갯수
	static int myArr[]; 
	// 충족여부 횟수
	static int checkSecret;
	
    public static void main(String[] args) throws IOException {
    	/**
    	 *	입출력 예시
    	 *	4 2  
    	 *	GATA
    	 *	1 0 0 1
    	 *
    	 *	결과: 2
    	 *	===========================
    	 *  첫번째 라인 P: 전체 문자열의 길이
    	 *  첫번째 라인 S: 부분문자열의 길이
    	 *  두번째 라인 char[] A: DNA문자열 
    	 *  세번째 라인: int[] checkArr: 충족해야 하는 'A''C''G''T' 갯수
    	 *  
    	 *  전체 문자열 중 부분 문자열에 속하는 각 문자의 갯수가 checkArr과 동일한지 체크합니다.
    	 *  체크를 한번 진행했다면 좌측 index를 1줄이고 우측 index를 1늘려 부분 문자열 갯수를 유지합니다.
    	 *  A 배열의 끝까지 순회했다면 결과 값을 출력합니다.
    	 *  프로그램을 종료합니다. 
    	 */
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
		int result = 0;
		
        // 문자열 전체 길이
        int s = Integer.parseInt(st.nextToken());
        // 부분 길이
        int p = Integer.parseInt(st.nextToken());
        
		// DNA 문자열을 담을 배열
        char a[] = br.readLine().toCharArray();
		
		// 비밀번호 체크 배열
		checkArr = new int[4];
		// 현재 상태
		myArr = new int[4];
        
		checkSecret = 0;
		
		// ACGT 개수 문자열
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < checkArr.length; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			// 충족해야 하는 문자의 갯수가 0이라면 checkSecret + 1
			if(checkArr[i] == 0) checkSecret++;
		}

		for(int i = 0; i < p; i++) {	// p만큼 부분 문자열 초기화
			add(a[i]); 
		}
		
		// 조건이 충족되면 결과값 + 1
		if(checkSecret == 4) {
			result++;
		}
		
		for(int i = p; i < s; i++) {
			// index가 1씩 증가할 때마다 가장 좌측의 index를 하나씩 제거
			int j = i - p;
			
			add(a[i]);
			remove(a[j]);
			
			if(checkSecret == 4)
				result++;
		}
		System.out.println(result);
        br.close();
    }
    
    private static void add(char c) {
    	switch(c) {
    	case 'A':
    		myArr[0]++;
    		if(myArr[0] == checkArr[0])
    			checkSecret++;
			break;
    	case 'C':
    		myArr[1]++;
    		if(myArr[1] == checkArr[1])
    			checkSecret++;
			break;
    	case 'G':
    		myArr[2]++;
    		if(myArr[2] == checkArr[2])
    			checkSecret++;
			break;
    	case 'T':
    		myArr[3]++;
    		if(myArr[3] == checkArr[3])
    			checkSecret++;
			break;
    	}
    }
    
    private static void remove(char c) {
    	switch(c) {
    	case 'A':
    		if(myArr[0] == checkArr[0])
    			checkSecret--;
    		myArr[0]--;
			break;
    	case 'C':
    		if(myArr[1] == checkArr[1])
    			checkSecret--;
    		myArr[1]--;
			break;
    	case 'G':
    		if(myArr[2] == checkArr[2])
    			checkSecret--;
    		myArr[2]--;
			break;
    	case 'T':
    		if(myArr[3] == checkArr[3])
    			checkSecret--;
    		myArr[3]--;
			break;
    	}
    }
}