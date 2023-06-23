import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max = 0;
        
        // 입력된 값을 판별하기 위한 큐
        Queue<Integer> q = new LinkedList<>();
        
        // 최대값을 넣어줄 스택
        Stack<Integer> st = new Stack<>();
        
        // 배열 길이가 1이면 1 반환
        if(priorities.length == 1) {
            return 1;
        }
        
        // 큐에 배열을 삽입
        for(int i = 0; i < priorities.length; i++) {
            q.offer(priorities[i]);
        }
        
        // 오름차순으로 정렬하여 스택에 삽입
        Arrays.sort(priorities);
        for(int i = 0; i <priorities.length; i++) {
            st.push(priorities[i]);
        }
        
        while(!st.isEmpty()) {
            // 스택의 마지막 값을 최대값으로 할당
            max = st.pop();

            // 큐의 길이만큼 순회
            for(int i = 0; i < q.size(); i++) {
                // 큐의 첫번째 값이 최대값과 일치하면
                if(q.peek() == max) {
                    // 큐의 첫번째 요소 제거
                    q.poll();
                    // 프로세스 실행 수 + 1
                    answer++;
                    
                    // 지정한 프로세스가 실행된 경우
                    if(location == 0) return answer;
                    
                    // 지정한 프로세스 위치 값 한칸 당기기
                    location--;
                    
                    // 최대값 바꿔주기 위한 break;
                    break;
                } else if(q.peek() != max){
                    // 큐의 첫번째 요소가 최대값과 일치하지 않으면
                    // 프로세스의 마지막으로 이동
                    q.offer(q.poll());
                    
                    // 지정한 프로세스의 위치가 맨 앞이라면
                    // 위치 값을 큐의 맨 뒤로 이동
                    if(location == 0) {
                    	location = q.size() - 1;
                    } else {
                        // 지정한 프로세스의 위치 한칸 당기기
                    	location--;
                    }
                    
                }
            }
        }
        return answer;
    }
}