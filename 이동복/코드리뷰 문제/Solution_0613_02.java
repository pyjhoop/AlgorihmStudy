import java.util.Stack;

class Solution {
    public int solution(String s) {
//    	월간 코드 챌린지 시즌2 괄호 회전하기

    	int answer = 0;
    	
    	// 새로운 문자열을 저장할 변수
        String newStr = s;
        
        // 1. 문자열 길이만큼 반복
        for(int i = 0; i < s.length(); i++) {
        
            // 2. 올바른 괄호 체크 함수 호출
            // 반환 값이 true면 answer + 1
            if(check(newStr)) answer++;
            
            // 3. 문자열의 맨 앞 문자를 맨 뒤로 붙여준다.
            newStr = newStr.substring(1) + newStr.substring(0, 1);
        }     
        
        return answer;
    }
    
    boolean check(String s) {
            Stack<Character> st = new Stack<>();
            boolean result = false;
            
            // 1. 문자가 '(', '{', '[' 중 하나면 stack.push 해준다.
            
            // 2. 문자가 ')', '}', ']' 중 하나면 stack.peek으로 비교한다.
            // peek해준 문자가 일치하는 열림 기호가 아니거나 stack이 비어있다면 false를 반환한다.
            for(char c: s.toCharArray()) {
                switch(c) {
                    case '[':
                        st.push(c);
                        break;
                    case '{':
                        st.push(c);
                        break;
                    case '(':
                        st.push(c);
                        break;
                    case ']':
                        if(st.isEmpty() || st.peek() != '[')
                            return false;
                        st.pop();
                        break;
                    case '}':
                        if(st.isEmpty() || st.peek() != '{')
                            return false;
                        st.pop();
                        break;
                    case ')':
                        if(st.isEmpty() || st.peek() != '(')
                            return false;
                        st.pop();
                        break;
                }
            }
            
            // 예외처리
            // 스택에 값이 남아 있다면 false를 반환한다.
            if(!st.isEmpty()) {
                return false;        
            }
        
            return true;
        }
}