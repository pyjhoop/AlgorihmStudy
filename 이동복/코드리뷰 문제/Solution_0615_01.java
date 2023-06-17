import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public String solution(int[] numbers) {
        final int LENGTH = numbers.length;
        
        // 숫자를 내림차 순으로 저장할 문자열 배열
        String [] sArr = new String[LENGTH];
		
		for(int i = 0; i < LENGTH; i++) {
			sArr[i] = String.valueOf(numbers[i]);
		}
		
        // 문자열 내림차 정렬
		Arrays.sort(sArr, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return (b+a).compareTo(a+b);
			};
		});
		
        // 첫번째 인덱스가 0이라면 0을 반환한다.
		if(sArr[0].equals("0")) return "0";
	
		StringBuilder answer = new StringBuilder();
		
		for(int i = 0; i < LENGTH; i ++) {
			answer.append(sArr[i]);
		}
		
		return answer.toString();
    }
}