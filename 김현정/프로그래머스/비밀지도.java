class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String temp1 = Integer.toString(arr1[i], 2);
            String temp2 = Integer.toString(arr2[i], 2);
            String result = "";
            
            while(temp1.length() < n){
                temp1 = "0" + temp1;                
            }
            while(temp2.length() < n){
                temp2 = "0" + temp2;
            }
            
            for(int j = 0; j<n; j++){
                if(temp1.charAt(j) == '1' || temp2.charAt(j) == '1'){
                    result += "#";
                } else {
                    result += " ";
                }
            }
            
            answer[i] = result;
        }
        return answer;
    }
}