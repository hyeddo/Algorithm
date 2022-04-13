package com.ssafy.study08;

//14832KB / 324ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11049_Matrix {

    static int[][] matrix, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "3\n" +
                "5 3\n" +
                "3 2\n" +
                "2 6";
        in = new BufferedReader(new StringReader(str));

        int N = Integer.parseInt(in.readLine());
        matrix = new int[N][2];
        dp = new int[N][N];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(solve(0, N-1));
    }

    private static int solve(int start, int end) {
        if(start == end) return 0;
        if(dp[start][end] != Integer.MAX_VALUE){
            return dp[start][end];
        }
        for (int i = start; i < end; i++) {
            int cost = solve(start, i) + solve(i + 1, end) + matrix[start][0] * matrix[i][1] * matrix[end][1];
            dp[start][end] = Math.min(dp[start][end], cost);
        }
        return dp[start][end];
    }
}
