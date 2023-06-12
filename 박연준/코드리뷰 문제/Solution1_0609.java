package org.example;

public class Solution1_0609 {

    public static void main(String[] args) {

        int n = 5;
        int[] arr1 = {9,20,28,18,11};
        int[] arr2 = {30,1,21,17,28};

        String[] answer = solution(n, arr1, arr2);

        for(String s: answer){
            System.out.println(s);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            // 일단 binary로 만들자
            String bi1 = Integer.toBinaryString(arr1[i]);
            String bi2 = Integer.toBinaryString(arr2[i]);

            // 길이가 n이 되도록 수정
            bi1 = replaceLength(bi1,n);
            bi2 = replaceLength(bi2,n);

            // 숫자를 #또는 공백으로 수정
            String result1 = "";

            for(int k = 0; k < n; k++){
                int sum = Integer.parseInt(bi1.charAt(k)+"") + Integer.parseInt(bi2.charAt(k)+"");
                if(sum > 0){
                    result1 +="#";
                }else{
                    result1 +=" ";
                }
            }


            answer[i] = result1;

        }
        return answer;
    }

    public static String replaceLength(String b, int n){
        if(b.length() < n){
            int s = n - b.length();
            for(int j = 0; j < s; j++){
                b = "0"+b;
            }
        }
        return b;
    }

}

