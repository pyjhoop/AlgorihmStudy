import java.util.Stack;

// 코테 설명
// 크레인 인형뽑기 게임
public class Sample1 {

    public static void main(String[] args) {
        solution(new int[][]{{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4});
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>(); //int형 스택 선언
        for(int i = 0; i < moves.length; i++){
            for (int j = 0; j < board.length; j++) {
                int chooseOne = board[j][moves[i]-1];
                // 인형이 있는 인덱스까지 조회
                if(chooseOne != 0){
                    // 스택이 비어 있지 않을때
                    if(!stack.empty()){
                        // 스택의 인형과 현재 선택인형을 비교하여 넣는다
                        if(chooseOne == stack.peek()){
                            stack.pop();
                            answer++;
                            board[j][moves[i]-1] = 0;
                        }else {
                            stack.push(chooseOne);
                            board[j][moves[i] - 1] = 0;
                        }
                    }else {
                        // 스택이 비어있다면 처음 인형을 넣는 로직
                        stack.push(chooseOne);
                        board[j][moves[i]-1] = 0;
                    }

                    // 그다음 for문은 의미가 없음
                    break;
                }
            }
        }
        // 인형은 한쌍씩 제거되기 때문에 곱하기 2
        return answer*2;
    }
}