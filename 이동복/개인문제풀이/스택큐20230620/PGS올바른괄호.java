import java.util.Stack;

class Solution {
	/*
	 * 2023-06-20
	 * 스택/큐
	 * 프로그래머스 올바른 괄호 / level2
	 * 
	 * 이전에 풀었던 백준의 괄호 문제와 같은 내용입니다.
	 * 
	 */
    boolean solution(String s) {
        boolean answer = true;

        // 문자열이 홀수면 false
        if(s.length() % 2 == 1) {
            return false;
        }
        
        Stack<Character> st = new Stack();
        
        for(char c : s.toCharArray()) {
        	// 올바른 괄호를 체크하는 함수를 호출합니다.
        	// false면 정답에 false를 출력합니다.
            if(!checkBracket(c, st)) {
                return false;
            }
        }
        
        // 비었으면 true
        // 안비었으면 false
        return !st.isEmpty() ? false : answer;
    }
    
    boolean checkBracket(char c, Stack<Character> st) {
    	// '(' 열린 괄호는 스택에 쌓습니다.
        if(c == '(') {
            st.push('(');
        } else {
        	// ')' 닫힘 괄호일 때,
        	// 스택이 비어있거나 열림 괄호가 있지 않으면 false를 반환합니다.
            if(st.isEmpty()) return false;
            if(st.pop() != '(') return false;
        }
        
        return true;
    }
}