package com.ssafy.algo.algo0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ2839_SugarDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "9";
        in = new BufferedReader(new StringReader(str));

        int N = Integer.parseInt(in.readLine());

        int five = 0;
        int three = 0;

        while (N % 5 != 0 && N >= 0) {
            three++;
            N -= 3;
        }
        if (N % 5 != 0) {
            System.out.println(-1);
        } else {
            five = N / 5;
            System.out.println(five + three);
        }
    }
}
