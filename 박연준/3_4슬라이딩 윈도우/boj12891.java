package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12891 {
    static int[] iArr = new int[4];

    static int[] iArr1 = new int[4];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = m-1;
        int count = 0;

        String[] sArr = br.readLine().split("");



        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++) {
            iArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int j = start; j <= end; j++) {
            if(sArr[j].equals("A")) {
                iArr1[0]++;
            }else if(sArr[j].equals("C")) {
                iArr1[1]++;
            }else if(sArr[j].equals("G")) {
                iArr1[2]++;
            }else {
                iArr1[3]++;
            }
        }

        while(end < n) {

            if(iArr1[0]>=iArr[0] && iArr1[1]>=iArr[1]&&iArr1[2]>=iArr[2]&&iArr1[3]>=iArr[3]) {
                count++;
            }

            end++;
            if(end == n) break;

            if(sArr[end].equals("A")) {
                iArr1[0]++;
            }else if(sArr[end].equals("C")) {
                iArr1[1]++;
            }else if(sArr[end].equals("G")) {
                iArr1[2]++;
            }else {
                iArr1[3]++;
            }

            if(sArr[start].equals("A")) {
                iArr1[0]--;
            }else if(sArr[start].equals("C")) {
                iArr1[1]--;
            }else if(sArr[start].equals("G")) {
                iArr1[2]--;
            }else {
                iArr1[3]--;
            }

            start++;

        }

        System.out.println(count);

    }

}