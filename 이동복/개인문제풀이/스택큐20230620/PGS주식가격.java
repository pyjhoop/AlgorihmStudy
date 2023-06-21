import java.util.Queue;
import java.util.LinkedList;


class Solution {
	/*
	 * 2023-06-20
	 * 스택/큐
	 * 프로그래머스 주식가격 / level2
	 * 
	 * 각 배열의 원소가 다음 원소보다 작으면 그 차이만큼 리턴
	 * 작지 않으면 다음 원소당 +1
	 * 
	 * prices			return
	 * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
	 * 
	 */
    public int[] solution(int[] prices) {
	int[] answer = new int[prices.length];

    Queue<Integer> q = new LinkedList();

    for(int i = 0; i < prices.length; i++) {
        q.offer(prices[i]);    
    }

    int i = 1;

    // 큐에 원소가 없을 때까지
    while(q.size() > 0) {
        int num = q.poll();

        int second = 0;

        for(int j = i; j < prices.length; j++) {
            ++second;

            if(num > prices[j]) {
                answer[i-1] = second;
                break;
            }
        }

        if(second == prices.length - i) answer[i-1] = second;
        i++;
    }   

    return answer;
        
    }
}