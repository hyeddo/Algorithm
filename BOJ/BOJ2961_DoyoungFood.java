package com.ssafy.algo.algo0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ2961_DoyoungFood {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "1\n" +
                "3 10";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        String[] str2 = in.readLine().split(" ");
        char[] S = new char[N];
        char[] B = new char[N];
        for(int i=0;i<N;i++){
            S[i] = str2[0].charAt(0);
            B[i] = str2[1].charAt(0);
        }

        int totalS = 1;
        int totalB = 1;


    }
}
