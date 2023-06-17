import java.util.*;
// 프로그래머스 괄호 회전하기
class Solution {
    // 스택 자료구조 활용
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        solution(new int[]{1, 1, 9, 1, 1, 1}, 5);
    }

    public static int solution(int[] priorities, int location) {
        List<Integer> usedNum = new ArrayList<>();

        // 큐 만들기
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        // 큐가 빌때까지
        int count = 0;
        while (!queue.isEmpty()){
            // poll로 검사할 숫자 꺼내기
            int temp = queue.poll();
            // 우선순위가 높은 숫자 검증
            boolean yn = validation(temp);
            // 우선순위가 가장 높을때 List로 이동 그렇지 않을때 다시 큐에 삽입
            if(yn){
//                usedNum.add(temp);
                usedNum.add(count);
            }else {
                queue.add(temp);
            }
        }

        int locationVal = priorities[location];

        int answer = 0;
        // List 인덱스 값 리턴
        for (int i = 0; i < usedNum.size(); i++) {
            if(usedNum.get(i) == locationVal){
                answer = i+1;
                break;
            };
        }

        System.out.println(answer);
        return answer;
    }

    private static boolean validation(int temp) {
        int size = queue.size();

        boolean val = true;
        // 큐의 사이즈 만큼 우선순위 검증
        for (int j = 0; j < size; j++) {
            int temp2 = queue.peek();
            if(temp2 <= temp){ // 꺼낸 값보다 우선순위가 작을때
                queue.add(queue.poll());
            }else { // 꺼낸 값보다 우선순위가 클때
                queue.add(queue.poll());
                val = false;
            }
        }
        return val;
    }
}