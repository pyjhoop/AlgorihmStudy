import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	PriorityQueue<Integer> pq_plus = new PriorityQueue<>((a, b) -> b - a);
    	PriorityQueue<Integer> pq_minus = new PriorityQueue<>();
    	for(int i = 0; i<n; i++) {
    		int temp = Integer.parseInt(br.readLine());
    		if(temp > 0) pq_plus.add(temp);
    		else pq_minus.add(temp);
    	}
    	int result = 0;
    	while(pq_plus.size() > 1) {
    		int a = pq_plus.poll();
    		int b = pq_plus.poll();
    		if(a == 1 || b == 1) result += a + b;
    		else result += a * b;
    	}
    	while(pq_minus.size() > 1) {
    		int a = pq_minus.poll();
    		int b = pq_minus.poll();
    		result += a * b;
    	}
    	
    	if(!pq_plus.isEmpty()) result += pq_plus.poll(); 
    	if(!pq_minus.isEmpty()) result += pq_minus.poll(); 
    	
    	System.out.println(result);
    }
}
