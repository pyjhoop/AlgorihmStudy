import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	PriorityQueue<Long> pq = new PriorityQueue<>();

    	for(int i= 0; i<n; i++) {
    		pq.add(Long.parseLong(br.readLine()));
    	}
    	
    	long result = 0;
    	while(pq.size() > 1) {
    		long a = pq.poll();
    		long b = pq.poll();
    		result += a + b;
    		
    		pq.add(a + b);
    	}
    	
    	result += pq.poll();
    	System.out.println(result);
    }
}
