import java.util.*;
import java.io.*;

/**
 * 그리디 방법 사용
 * - 더 간단하다. 저장 공간이 필요 없다.
 * - 동전 개수가 최소인 가장 최선의 방법은 가장 큰 값의 동전을 선택하는 것. 
 */
class Main {
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] coins = new int[n];
    	
    	for(int i = 0; i<n; i++) {
    		coins[i] = Integer.parseInt(br.readLine());
    	}
    	
    	int[] count = new int[n];
    	int j = 0;
    	for(int i = n - 1; i >= 0; i--) {
    		if(coins[i] <= k) {
    			count[j++] = k / coins[i];
    			k = k % coins[i];
    		}
    	}
    	int result = 0;
    	for(int x : count) {
    		result += x;
    	}
    	
    	System.out.println(result);
    }
}
