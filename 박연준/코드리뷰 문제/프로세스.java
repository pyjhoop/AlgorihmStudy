package org.example;

import java.util.*;


public class 프로세스 {

    public static void main(String[] args){

        int[] priorities = {2,1,3,2};

        int location = 2;
        System.out.print(solution(priorities, location));

    }

    public static int solution(int[] priorities, int location){

        int answer = 0; // 프로세스 실행 횟수
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: priorities){
            pq.add(i);
        }

        // 1,1,9,1,1,1
        // 9,1,1,1,1,1

        //3,2,2,1
        while(!pq.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                //우선 순위로 프로세스가 종료됨.
                // 우선순위 값을 poll 해야하는데 배열의 몇번째 인덱스인지 확인하기 위해
                if(pq.peek() == priorities[i]){
                    pq.poll();
                    answer++;
                    // location과 방금 실행 종료된 프로세스의 위치가 같은 조건
                    if(i == location){
                        return answer;
                    }
                }
            }
        }
        return answer;

    }
}
