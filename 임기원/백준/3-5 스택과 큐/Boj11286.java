package org.example;

//  절대힙구하기
public class Boj11286 {
import java.util .*;
import java.io .*;
    public class Main {
        public static void main(String[] args) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());  // 연산의 개수

            // 절댓값 힙을 위한 Comparator 구현
            Comparator<Integer> absComparator = new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);

                    if (absA == absB) {
                        return Integer.compare(a, b);
                    } else {
                        return Integer.compare(absA, absB);
                    }
                }
            };

            // 절댓값 힙 초기화
            PriorityQueue<Integer> absHeap = new PriorityQueue<>(absComparator);

            // 연산 처리
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(br.readLine());

                if (x == 0) {
                    if (absHeap.isEmpty()) {
                        sb.append("0\n");
                    } else {
                        sb.append(absHeap.poll()).append("\n");
                    }
                } else {
                    absHeap.offer(x);
                }
            }

            // 결과 출력
            System.out.println(sb.toString());
        }
    }
}