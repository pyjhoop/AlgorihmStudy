import java.util.Arrays;
import java.util.ArrayList;

public	class Pgs12910 {
	/* 문제 설명
	array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
	divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요. */
    public int[] solution(int[] arr, int divisor) {
        String list = "";
        Arrays.sort(arr);
        
        for(int a : arr) {
        	// divisor로 나누어 떨어지는 요소를 문자열로 저장
            if(a % divisor == 0) {
                list += a + " ";
            }
        }

        // " "를 구분자로 문자열 배열 생성
        String[] answerStr = list.split(" ");

        // 나누어 떨어지는 요소가 없다면 -1 반환
        if(list.trim() == "") {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[answerStr.length];
        int i = 0;
        
        // 정수형 배열로 답을 반환하기 위한 작업.
        for(String s : answerStr) {
            answer[i++] = Integer.parseInt(s);    
        }
        
        return answer;
    }
}
