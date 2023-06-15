import java.util.*;
// 프로그래머스
// 가장 큰 수
class Solution {
    // 스택 자료구조 활용
    public String solution2(int[] numbers) {
        // 정수 배열을 문자열로 변환하여 저장
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        // 람다식과 정렬을 이용하여 큰수 만들기
        // (a+b)와 (b+a)를 비교하여 큰수가 앞에 정렬되게 만들수있다
        // (a+b)와 (b+a)순서로 작성하게 되면 반대로 작은수를 만들수있다
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // 가장큰수가 0일경우에 0이 여러번 들어가있는 상황이여서 return 0
        if (nums[0].equals("0")) {
            return "0";
        }

        // 정렬된 숫자들을 이어붙여서 결과 생성
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }
}