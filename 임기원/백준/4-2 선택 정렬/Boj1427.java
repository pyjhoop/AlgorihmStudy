//  내림차순으로 자릿수 정렬하기
import java.util .*;
import java.io .*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(Sysyem.in);
            String str = sc.next();
            int[] A = new int[str.length()]; // 배열 생성하기
            for (int i = 0; i < str.length(); i++) {
                A[i] = Intger.parseInt(str.substring(i,i + 1)); // string in 배열
            }
            for (int i = 0; i < str.length(); i++) {
                int Max = i; // 결정된 수 제외
                for (int j = 0; j < str.length(); j++) {
                    if (A[j] > A[Max]) { //
                        Max = j;
                    }
                }
                if (A[j] < A[Max]) { // 바꾸기
                    int temp = A[i];
                    A[i] = A[Max];
                    A[Max] = temp;
                }
            }

            for (int i = 0; i < str.length(); i++) {
                System.out.println(A[i]);
            }
        }
    }
}