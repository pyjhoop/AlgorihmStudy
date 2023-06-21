import java.util.*;

class Solution {
    int answer, length;
    public int solution(int[] numbers, int target) {
        length = numbers.length;
        
        DFS(0, 0, numbers, target);
        return answer;
    }
    
    public void DFS(int depth, int num, int[] numbers, int target){
        if(depth == length){
            answer += (num == target)? 1 : 0;
            return;
        }
        DFS(depth + 1, num + numbers[depth], numbers, target);
        DFS(depth + 1, num - numbers[depth], numbers, target);

    }
}
