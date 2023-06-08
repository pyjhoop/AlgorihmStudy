package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Boj1546 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        // 요소 리스트
        List<Integer> list = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(list);

        Double max = Double.parseDouble(list.get(N-1)+"");

        Double result = list.stream()
                        .mapToDouble(e -> e/max*100).sum()/N;

        System.out.println(result);

    }
}