import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = Arrays.stream(numbers)
            .boxed()
            .map(i -> String.valueOf(i))
            .collect(Collectors.toList());
        
        Collections.sort(list, (a, b) -> {
            String a_b = a + b;
            String b_a = b + a;
            
            for(int i = 0; i<a_b.length(); i++){
                if(a_b.charAt(i) == b_a.charAt(i)) continue;
                if(a_b.charAt(i) > b_a.charAt(i)) return -1; // 오름차순
                else return 1; // 내림차순
            }
            return 0; // 동일
        });
        
        for(String x : list){
            answer += x;
        }
        
        if(answer.charAt(0) == '0') answer = "0"; // [0, 0, 0] 일 때 0 출력되도록
        return answer;
    }
    
}