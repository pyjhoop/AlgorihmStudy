package Main;
import java.util.*;
import java.io.*;

/**
 * 아이디어가 중요했던 문제
 * 1. k번째 수는 k보다 작거나 같아야만 한다. => 반드시 1 ~ k안에 답이 있음
 * 2. 2차원 배열에서 중앙값보다 작은 수는 중앙값을 N으로 나눈 값과 같다.
 */
class Main {
	
    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	
    	long start = 1;
    	long end = k;
    	
    	while(start < end) {
    		long mid = (start + end) / 2;
    		long small_cnt= 0;
    		for(int i = 1; i <= n; i++) {
    			small_cnt += Math.min(mid / i, n);
    		}
//    		if(small_cnt == k) {  // 안되는 이유를 모르겠다.
//    			start = mid; 
//    			break;
//    		} else 
    		if (small_cnt < k){ 
    			start = mid + 1;
    		} else { // 작거나 같은 값이 k이상이면 정답일 가능성 있음(중복도 있어서)
    			end = mid;
    		}
    	}
    	
    	System.out.println(start);
    }
}