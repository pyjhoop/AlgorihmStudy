package org.example;

//  DBA 비밀번호
public class Boj12891 {
import java.util .*;
import java.io .*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays;
    public class Main {
        static int checkArr[]; // 비밀번호 체크 배열
        static int myArr[]; // 비교한 현재 배열
        static int checkSecret; // 몇 개 충족했는지
        public static void main(String[] args) throws IOException, NumberFormatException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new  StringTokenizer(bf.readLine());
            int S = Integer.parseInt(st.nextToken()); // 문자열 크기
            int P = Integer.parseInt(st.nextToken()); // 부분 문자열 크기
            int count = 0; // 결과값
            char A[] = new char[S]; // 문자열 배열
            checkArr = new int[4];
            myArr = new int[4];
            checkSecret = 0; // 충족개수 초기화
            A = bf.readLine().toCharArray();
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < 4; i++) {
                checkArr[i] = Integer.parseInt(st.nextToken());
                if(checkArr[i] == 0){
                    checkSecret++;
                }
            }
            for (int i = 0; i < P; i++) {
                Add(A[i]);
            }
            if(checkSecret == 4) {
                count++;
            }
            // 슬라이딩 윈도우 처리 부분
            for (int i = P; i < S; i++) {
                int j = i - P;
                Add(A[i]);
                Remove(A[j]);
                if(checkSecret == 4){
                    count++;
                }
            }
            System.out.println(count);
            bf.close();
        }

        private static void Add(char c){
            switch (c) {
                case 'A':
                    myArr[0]++;
                    if(myArr[0] == checkArr[0]){
                        checkSecret++;
                    }
                    break;
                case 'C':
                    myArr[1]++;
                    if(myArr[1] == checkArr[1]){
                        checkSecret++;
                    }
                    break;
                case 'G':
                    myArr[2]++;
                    if(myArr[2] == checkArr[2]){
                        checkSecret++;
                    }
                    break;
                case 'T':
                    myArr[3]++;
                    if(myArr[3] == checkArr[3]){
                        checkSecret++;
                    }
                    break;
            }
        }

        private static void Remove(char c) {
            switch (c) {
                case 'A':
                    if (myArr[0] == checkArr[0]) {
                        checkSecret--;
                    }
                    myArr[0]--;
                    break;
                case 'C':
                    if (myArr[1] == checkArr[1]) {
                        checkSecret--;
                    }
                    myArr[1]--;
                    break;
                case 'G':
                    if (myArr[2] == checkArr[2]) {
                        checkSecret--;
                    }
                    myArr[2]--;
                    break;
                case 'T':
                    if (myArr[3] == checkArr[3]) {
                        checkSecret--;
                    }
                    myArr[3]--;
                    break;
            }
        }
    }
}