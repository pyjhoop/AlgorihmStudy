// 입출력 예시
// 4 2
// 1 1 1 1
// 3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
    	/**
    	 *	입출력 예시
    	 *	4 2  
    	 *	1 1 1 1
    	 *
    	 *	결과: 3
    	 *	===========================
    	 *  첫번째 라인 n: 배열의 요소 갯수
    	 *  첫번째 라인 m: 요소들의 합
    	 *  두번째 라인을 정수형 배열로 입력받습니다.
    	 *  정수형 배열의 요소들을 더해 m을 충족하는 횟수를 출력합니다.
    	 *  
    	 */
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] A = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());     
        }
        
        int i = 0;
        int j = 0;
        int sum = 0;
        int result = 0;
               
        while(true) {
             if(sum>=m){
                sum-=A[i++];
            } else if(j==n){ // 오른쪽 인덱스가 마지막 요소까지 순회하면 break;
                break;
            } else{
                sum+=A[j++];
            }
            if(sum == m) {
                result++;
            }
        }
        
        System.out.println(result);
        br.close();
    }
}