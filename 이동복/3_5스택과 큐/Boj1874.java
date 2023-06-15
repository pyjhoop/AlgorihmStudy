import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1874 {
	/*
	 *	[BOJ] 스택수열 1874 / 실버2 
	 *	입력 값 첫째 줄은 입력받을 수열의 갯수: N
	 *	입력 값 둘째 줄 이후로 수열 값을 받는다: A
	 *
	 *  출력: push 연산은 "+" pop 연산은 "-"
	 *  수열이 성립되지 않으면 "NO"를 출력한다.
	 */
	
	// 오름차순 자연수
    static int n = 0;
    
    // 수열을 저장할 stack
    static Stack<Integer> st = new Stack<>();
    
    // 결과값 반환을 위한 문자열 저장 변수
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	int A = Integer.parseInt(br.readLine());
        
        	// 수열 만들기 함수 호출
        	if(!makeNum(A)) break;
        }
        System.out.println(sb);
    }

	private static boolean makeNum(int a) {
		// 현재 수열이 오름차순 숫자 이상라면
		if(a >= n) {
			// 오름차순 자연수 + 1
			// stack에 값 저장
			// 결과값에 "+" 문자열 추가
			while(a != n) {
				n++;
				st.push(n);
				sb.append("+").append("\n");
			}
			// 현재 수열 == 오름차순 자연수
			if(a == n) {
				// stack의 현재 수열 값 출력
				// 결과값에 "-" 문자열 추가
				st.pop();
				sb.append("-").append("\n");
			}
		// 현재 수열 값이 오름차순 자연수보다 작울 경우
		} else if(a < n) {
			// stack에 저장된 마지막 값이 현재 수열 값 보다 작다면 수열이 성립되지 않는다.
			// 따라서 "NO"문자열을 결과값에 저장하고 함수 호출을 종료한다.
			if(st.peek() < a) {
				sb.setLength(0);
                sb.append("NO");
				return false;
			} else {
				// stack의 마지막 값 제거
				// 결과값에 "-" 문자열 추가
				st.pop();
				sb.append("-").append("\n");
			}
		}
		return true;
	}
}