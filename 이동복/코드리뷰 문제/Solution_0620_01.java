class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, target, 0);
        
        return answer;
    }

    // 깊이 우선 탐색
    void dfs(int[] numbers, int depth, int target, int sum) {
        if(numbers.length == depth) {
            if(target == sum) {
                answer++;
            }
            return;
        }
        
        // 다음 노드 값 연산
        dfs(numbers, depth + 1, target, sum + numbers[depth]);
        dfs(numbers, depth + 1, target, sum - numbers[depth]);
    }
}