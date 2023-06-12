class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        // 1. n번만큼 반복하는 반복문 생성
        for(int i = 0; i < n; i++) {
            // 2. 내부에 arr1[i]과 arr2[i]를 ""와 "#"로 반환하는 메서드 호출
            String cArr1 = convertNum(n, arr1[i]);
            String cArr2 = convertNum(n, arr2[i]);
            
            // 3. 반환된 문자열을 비교 후 결과 배열에 추가
            answer[i] = compareArrs(cArr1, cArr2);
        }
        
        return answer;
    }
    
    public String compareArrs(String arr1, String arr2) {      
        char[] charArr1 = arr1.toCharArray();
        char[] charArr2 = arr2.toCharArray();
        
        String result = "";
        
        // System.out.println("charArr1=" + arr1);
        // System.out.println("charArr2=" + arr2);
        
        for(int i = 0; i < charArr1.length; i++) {
            if(charArr1[i] == '#' || charArr2[i] == '#') {
                result += "#";
            } else {
                result += " ";
            }
        }
        
        return result;
    }
    
    public String convertNum(int length, int n) {
        String result = "";
        int targetN = n;
        
        while(targetN > -1) {
            if(targetN == 0) {
                result = " " + result;
                break;
            }
            
            if(targetN == 1) {
                result = "#" + result;
                break;
            }
            
            if(targetN % 2 == 0) {
                result = " " + result;
            } else {
                result = "#" + result;
            } 
            
            targetN /= 2;           
        }
        
        while(result.length() != length) {
            result = " " + result;
        }
        
        return result;
    }
}