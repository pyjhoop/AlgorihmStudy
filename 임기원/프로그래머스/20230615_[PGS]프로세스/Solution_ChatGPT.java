import java.util.Stack;
// 프로그래머스 괄호 회전하기
class Solution {
    // 스택 자료구조 활용
    public int solution(String s) {
        public static int solution ( int[] priorities, int location){
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> sortedList = new ArrayList<>();

            // 실행 대기 큐에 프로세스를 넣음
            for (int i = 0; i < priorities.length; i++) {
                queue.add(priorities[i]);
                sortedList.add(priorities[i]);
            }

            // 프로세스 중요도를 내림차순으로 정렬
            Collections.sort(sortedList, Collections.reverseOrder());

            while (!queue.isEmpty()) {
                int current = queue.poll(); // 큐에서 프로세스를 꺼냄

                // 우선순위가 가장 높은 프로세스인 경우
                if (current == sortedList.get(0)) {
                    answer++; // 실행 순서 증가

                    // 원하는 프로세스의 위치인 경우 반환
                    if (location == 0) {
                        break;
                    }

                    // 우선순위가 가장 높은 프로세스를 처리한 경우 리스트에서 삭제
                    sortedList.remove(0);

                } else { // 우선순위가 높은 프로세스가 아닌 경우 큐에 다시 넣음
                    queue.add(current);
                }

                // 원하는 프로세스의 위치 갱신
                location = (location - 1 + queue.size()) % queue.size();
            }

            return answer;
        }
    }
}