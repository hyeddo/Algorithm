package com.ssafy.study04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2559_Sequence {

    static int N, K;
    static int[] temparature;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "10 5\n" +
                "3 -2 -4 -9 0 3 7 13 8 -3";
        in = new BufferedReader(new StringReader(str));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        temparature = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            temparature[i] = Integer.parseInt(st.nextToken());
        }

        int ans = findMax();
        System.out.println(ans);
    }

    private static int findMax() {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            int temp = 0;
            for (int j = i; j < i + K; j++) {
                temp += temparature[j];
            }
            result = Math.max(result, temp);
        }
        return result;
    }
}
