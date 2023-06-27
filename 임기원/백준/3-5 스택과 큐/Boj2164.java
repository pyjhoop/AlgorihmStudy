package org.example;

//  카드게임
public class Boj2164 {
import java.util .*;
import java.io .*;
    public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scammer(System.in);

            int N = sc.nextInt();  // 카드의 개수


            // 카드 큐 초기화
            Queue<Integer> cards = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                cards.offer(i);
            }

            // 카드 섞기
            while (cards.size() > 1) {
                // 맨 위의 카드를 버리기
                cards.poll();

                // 맨 위의 카드를 아래로 옮기기
                int topCard = cards.poll();
                cards.offer(topCard);
            }

            // 마지막에 남는 카드 번호 출력
            System.out.println(cards.peek());
        }
    }
}