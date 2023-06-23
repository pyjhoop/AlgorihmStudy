import java.util.Scanner;

public class Boj1427 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
        final int LENGTH = str.length();
        int[] nArr = new int[LENGTH];
		
        for(int i = 0; i < LENGTH; i++) {
            nArr[i] = Integer.parseInt(str.substring(i, i+1));
        }
        
		for(int i = 0; i < LENGTH - 1; i++) {
			int max = i;

			for(int j = i + 1; j < LENGTH; j++) {			
				if(nArr[j] > nArr[max]) {
					max = j;
				}
			}
			
            if(nArr[max] > nArr[i]) {
                int temp = nArr[i];
			    nArr[i] = nArr[max];
			    nArr[max] = temp;                
            }
		}
		
        for(int i = 0; i < LENGTH; i++) {
            System.out.print(nArr[i]);
        }
	}
}