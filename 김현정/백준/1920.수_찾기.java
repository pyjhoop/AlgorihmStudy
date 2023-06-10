package Main;
import java.util.*;
import java.io.*;

class Main {
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] arr1 = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		arr1[i] = Integer.parseInt(st.nextToken()); 
    	}
    	
    	Arrays.sort(arr1);
    	
    	int m = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());

    	for(int i = 0; i<m;i++) {
    		int target = Integer.parseInt(st.nextToken());
    		int start = 0;
    		int end = n - 1;
    		boolean flag = false;
    		while(start <= end) {
    			int mid = (start + end) / 2;
    			if(target == arr1[mid]) {
    				flag = true;
    				break;
    			}
    			else if(target < arr1[mid]) {
    				end = mid - 1;
    			}
    			else {
    				start = mid + 1;
    			}
    		}
    		
    		if(flag) System.out.println("1");
    		else System.out.println("0");
    	}
    }
}