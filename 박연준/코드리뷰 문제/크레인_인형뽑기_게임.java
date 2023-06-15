package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;


public class 크레인_인형뽑기_게임 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.print(solution(board,moves));
//        System.out.println(board.length);
    }

    public static int solution(int[][] board, int[] moves){

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        // moves의 길이만큼 일단 반복해야함.
        for(int i = 0; i < moves.length; i++){
            // moves의 i번째 인덱스를 이용해 board에서 데이터 추출
            int pick = moves[i]-1;
            int temp = 0;

            for(int j = 0; j<board.length; j++){
                if(board[j][pick] != 0){
                    temp = board[j][pick];
                    board[j][pick] = 0;
                    break;
                }
            }

            // stack에 쌓는데 그전에 동일한 값이 있는지 비교하고
            // 동일값이 있으면 pop 없으면 push 비교는 peak로 비교하기
            if(temp !=0 && stack.isEmpty()){
                stack.push(temp);
            }else if(temp !=0){
                int com = stack.peek();
                if(com == temp){
                    stack.pop();
                    count++;
                }else{
                    stack.push(temp);
                }
            }

//            System.out.println(stack.peek());
        }

        return count *2;

    }
}
