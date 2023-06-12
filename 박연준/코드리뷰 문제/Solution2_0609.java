package org.example;

public class Solution2_0609 {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {8,20,28,18,11};
        int[] arr2 = {1,1,21,17,28};

        String[] answer = solution(n, arr1, arr2);
        for(String s: answer){
            System.out.println(s);
        }

    }

    /**
     * 1. 비트의 | 연산자를 이용해 두 수중 하나라도 1이면 1 2개다 0이면 0으로 변환
     * 2. 2진수의 길이가 n이 되도록 수정 -> 0을 공백으로 바꿔야하니 format 사용 가능
     * 3. 1인 경우 #으로 replace
     * 4. 0인 경우 " "으로 replace
     *
     */
    public static String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];

        String temp ="";
        for(int i = 0; i < n; i++){
            temp = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = String.format("%"+n+"s",temp);
            answer[i] = answer[i].replaceAll("1","#");
            answer[i] = answer[i].replaceAll("0"," ");
        }

        return answer;


    }

}
