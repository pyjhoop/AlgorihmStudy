import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.length() % 2 != 0) return answer;
        
        for(int i = 0; i < s.length(); i++){
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for(int j = i; j < i + s.length(); j++){
                int index = (j < s.length())? j : j - s.length();
                char target = s.charAt(index);
                
                if(target == '(' || target == '[' || target == '{') stack.push(target);
                else {
                    if(stack.isEmpty() || !isCollect(stack.peek(), target)){// 틀렸다면
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }            
            if(flag) answer++;
        }
        
        return answer;
    }
    
    public boolean isCollect(char open, char close){
        switch(open){
            case '(' : if(close == ')') return true;
            case '[':  if(close == ']') return true;
            case '{':  if(close == '}') return true;                
        }
        return false;
    }
}