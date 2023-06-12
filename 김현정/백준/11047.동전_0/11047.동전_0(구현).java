import java.util.*;
import java.io.*;

/**
 * 작은 수부터 선택, 큰 값으로 나아가는 방법 사용
 */
class Main {
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] coin = new int[n];
    	
    	int new_n = 0;
    	for(int i = 0; i<n; i++) {
    		int temp = Integer.parseInt(br.readLine());
    		if(temp <= k)
    			coin[new_n++] = temp; 
    	}
    	
    	Coin[] used = new Coin[new_n];
    	used[0] = new Coin(1, k);
    	for(int i = 0; i < new_n - 1; i++) {
    		int div = coin[i + 1] / used[i].value ;
    		int count = used[i].count;

    		used[i + 1] = new Coin(coin[i + 1], count / div);
    		used[i].count = count % div;
    	}
    	
    	int result = 0;
    	for(Coin x : used) {
    		result += x.count;
    	}
    	System.out.println(result);
    }
}

class Coin {
	int value;
	int count;
	
	Coin(int v, int c){
		this.value = v;
		this.count = c;
	}
}