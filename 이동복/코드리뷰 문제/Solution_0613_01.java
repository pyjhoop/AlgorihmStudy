import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 뽑은 인형을 저장할 리스트
        ArrayList<Integer> pickedList = new ArrayList<>();
        
        // moves 길이 만큼 반복
        for(int i=0; i < moves.length; i++) {
            // 해당 인덱스 값 가져오기 - 0이 아닐 때까지
            for(int j=0; j < board.length; j++) {
                
                int pickedNum = board[j][moves[i]-1];
                
                // 인형이 0이 아니면 pickedList에 저장하기
                if(pickedNum != 0) {
                    pickedList.add(pickedNum);
                    // 숫자를 뽑은 경우 빈공간으로 만들어주기
                    board[j][moves[i]-1] = 0;
                    
                    if(pickedList.size() > 1) {
                        int size = pickedList.size();
                        // pcikedList의 마지막 idx와 마지막-1 idx비교하기
                        if(pickedList.get(size-2) == pickedList.get(size-1)) {
                            // 저장된 인형과 직전 idx의 인형 같으면 list의 마지막 요소, 직전 요소 지우기 + answer + 2
                            pickedList.remove(size-1);
                            pickedList.remove(size-2);
                            answer += 2;
                        }
                    }
                   break;
                }
            }
        }
        
        return answer;
    }
}