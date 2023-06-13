package org.example;

import java.util.Stack;


public class 괄호회전하기 {

    public static void main(String[] args){

        String s = "}]()[{";

        System.out.print(solution(s));

    }

    public static int solution(String s){
        int count = 0;
        //0~length-1까지 회전
        for(int i = 0; i < s.length(); i++){
            // 맨앞을 맨뒤로 보내면 됨
            if(i != 0) {
                s = s.substring(1) + s.charAt(0);
            }

            Stack<String> stack = new Stack<>();

            // s의 길이만큼 반복문으로 stack에 쌓는데 반대 문자열을 만나면 pop
            String[] arr = s.split("");

            stack.push(arr[0]);

            for(int j = 1; j< s.length(); j++){
                String temp = "";
                if(!stack.isEmpty()){
                    temp = stack.peek();
                }
                if((temp.equals("[") && arr[j].equals("]")) ||(temp.equals("(") && arr[j].equals(")"))||(temp.equals("{") && arr[j].equals("}"))){
                    stack.pop();
                }else {
                    stack.push(arr[j]);
                }
            }
            if(stack.isEmpty()) {
                count++;
            }

        }

        return count;

    }
}
