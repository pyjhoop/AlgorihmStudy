package org.example;

import java.util.*;


public class 가장큰수 {

    public static void main(String[] args){

        int[] numbers = {6,10,2};

        System.out.print(solution(numbers));

    }

    public static String solution(int[] numbers){

        //610,106,62,102,210
        // 610 106보다 커 6이 앞으로
        // 이문자열을 더했을 때 더 큰수를
        // 이러한 식으로 정렬 조건을 주면 된다.
        String answer = "";
        String[] sArr = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            sArr[i] = numbers[i]+"";
        }


        // o2+o1이 크면 o2가 앞에 정렬
        // 6,10 -> 610, 106
        Arrays.sort(sArr,(o1, o2)->
                (o2+o1).compareTo(o1+o2)
        );

        // 맨앞에 0이 존재하는 경우
        if(sArr[0].equals("0")) return "0";


        for(String s:sArr){
            answer += s;
        }

        return answer;

    }
}
