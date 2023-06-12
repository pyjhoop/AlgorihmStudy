package org.example;

import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int bitMask = 1 << (n - 1);  // 각 자리수를 확인하기 위한 비트 마스크

            for (int j = 0; j < n; j++) {
                int num1 = arr1[i] & bitMask;
                int num2 = arr2[i] & bitMask;

                if (num1 > 0 || num2 > 0) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }

                bitMask = bitMask >> 1;
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}