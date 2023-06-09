import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
    	/**
    	 *	입출력 예시
    	 *	10 2  
    	 *	3 -2 -4 -9 0 3 7 13 8 -3
    	 *
    	 *	결과: 21
    	 *	===========================
    	 *  첫번째 라인 N: 배열의 요소 갯수
    	 *  첫번째 라인 K: 배열의 연속된 숫자 갯수 
    	 *  두번째 라인을 정수형 배열로 입력받습니다.
    	 *  합배열 공식을 통해 정답 도출 후 출력합니다.
    	 *  S[j] - S[i-1] 
    	 *  
    	 */
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] S = new int[N+1];

        for(int i=1; i <= N; i++) {
            // 합 배열
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }
        
        int max = -10000001;
        
        for(int i=K; i <= N; i++) {
            // i부터 j까지
            // S[j] - S[i-1]
            int sum = S[i] - S[i-K];
            if(sum > max) max = sum;
        }
        
        System.out.println(max);
    }
}