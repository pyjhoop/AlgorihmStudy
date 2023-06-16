package Main;
import java.util.*;
import java.io.*;
/**
 * 틀린 답 
 * 이유: 30 30 40 50 일 때
 * - (30 + 30) + (60 + 40) + (100 + 50) = 310 이 답이 아니라
 * - (30 + 30) + (40 + 50) + (60+ 90) = 300 이 답임 
 */
class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	long[] arr = new long[n];
    	long[] sum = new long[n - 1];
    	long result = 0;

    	for(int i= 0; i<n; i++) {
    		arr[i] = Long.parseLong(br.readLine());
    	}
    	
    	Arrays.sort(arr);
    	if(n > 1) {
    		sum[0] = arr[0] + arr[1];

        	for(int i = 1; i < n - 1; i++) {
        		sum[i] = sum[i - 1] + arr[i + 1];
        	}
        	for(long x : sum) {
        		result += x;
        	}
    	}
    	
    	System.out.println(result);
    }
}
