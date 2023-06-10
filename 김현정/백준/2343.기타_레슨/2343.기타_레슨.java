package Main;
import java.util.*;
import java.io.*;

class Main {
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int start = 0;
    	int end = 0;
    	int[] arr = new int[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		int temp = Integer.parseInt(st.nextToken());
    		start = Math.max(start, temp);
    		end += temp;
    		arr[i] = temp;
    	}
    	
    	while(start < end) {
    		int mid = (start + end) / 2;
    		int cnt = 1;
    		int sum = 0;
    		for(int i = 0; i<n; i++) {
    			if(cnt > m) break;
    			sum += arr[i];
    			if(sum > mid) {
    				sum = arr[i];
    				cnt++;
    			}
    		}
    	   	if(cnt > m) start = mid + 1;
    	   	else end = mid;
    	}
    	
    	System.out.println(start);
    }
}