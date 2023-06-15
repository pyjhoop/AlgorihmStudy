import java.util.*;

class Node {
    int loc;
    int value;
    
    Node(int loc, int value){
        this.loc = loc; this.value = value;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Integer[] sorted = new Integer[priorities.length]; // reverseOrder해줘야해서 Box
        Queue<Node> q = new LinkedList<>();
        
        // 세팅
        for(int i = 0; i<priorities.length; i++){
            q.add(new Node(i, priorities[i]));
            sorted[i] = priorities[i];
        }
        
        // 우선순위 확인용 정렬
        Arrays.sort(sorted, Collections.reverseOrder());
        
        int index = 0;
        while(!q.isEmpty()){
            if(q.peek().value == sorted[index]){ // 실행해야하는 우선순위라면
                answer++; index++;
                if(q.poll().loc == location) return answer; // 확인하려는 위치인지 확인
            } else {
                q.add(q.poll());
            }            
        }        
        return answer;
    }
}