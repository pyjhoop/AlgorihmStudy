package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj2785 {

    public static void main(String[] args) throws Exception {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList();
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            a.add(tmp);
        }

        Collections.sort(a);

        while(true) {
            if(a.size() <= 1)
                break;
            a.set(0, a.get(0) - 1);
            a.remove(a.size() - 1);
            if(a.get(0) == 0)
                a.remove(0);
            cnt++;
        }
        System.out.println(cnt);

    }

}
