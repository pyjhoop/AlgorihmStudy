import java.util.*;
// 프로그래머스
// 가장 큰 수
class Solution {
    // 스택 자료구조 활용
    public static String solution(int[] numbers) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {

            if(numbers[i]>9){
                String[] strings = Integer.toString(numbers[i]).split("");
                for (String test : strings){
                    list.add(Integer.parseInt(test));
                }
            }else{
                list.add(numbers[i]);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        System.out.println(answer);
        return answer;
    }
}