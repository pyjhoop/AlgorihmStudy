import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                BFS(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void BFS(int start, int length, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();        
        q.add(start);
        
        while(!q.isEmpty()){
            int target = q.poll();
            for(int i = 0; i<length; i++){
                if(!visited[i] && computers[target][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}