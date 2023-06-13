import java.util.Stack;
// 프로그래머스 괄호 회전하기
class Solution {
    // 스택 자료구조 활용
    public int solution(String s) {
        int answer = 0;

        // for문을 돌면서 문자열 회전
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if(checkValidParentheses(s)){
                answer++;
            }

        }
        return answer;
    }

    // 올바른 괄호 문자열인지 검사하는 메소드
    private boolean checkValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(isOpenParenthese(c)){ // 여는 괄호인 경우 스택에 삽입
                stack.push(c);
            } else { // 닫는 괄호인 경우 스택에서 맨 위의 요소와 짝을 검사
                if(stack.empty() || !isPair(stack.peek(), c)){
                    return false; // 짝이 맞지 않으면 false 반환
                }
                stack.pop(); // 짝이 맞으면 스택에서 요소 제거
            }
        }
        return stack.isEmpty(); // 스택이 비어있으면 true, 아니면 false 반환
    }

    // 짝이 맞는지 확인하는 메서드
    private boolean isPair(Character open, char close) {
        if((open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}')){
            return true;
        }else {
            return false;
        }
    }

    // 여는 괄호인지 확인하는 메서드
    private boolean isOpenParenthese(char c) {
        if (c == '(' || c == '[' || c == '{'){
            return true;
        }else {
            return false;
        }
    }
}