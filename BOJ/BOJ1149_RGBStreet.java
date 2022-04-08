package com.ssafy.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ1149_RGBStreet {

    static int N;
    static int[][] cost;
    static int[][] dp;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        in = new BufferedReader(new StringReader(str));

        N = Integer.parseInt(in.readLine());
        cost = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        ans = Math.min(RGB(N - 1, 0), Math.min(RGB(N - 1, 1), RGB(N - 1, 2)));
        System.out.println(ans);
    }

    private static int RGB(int i, int color) {
        if(dp[i][color] == 0){
            if(color == 0){
                dp[i][0] = Math.min(RGB(i-1, 1), RGB(i-1, 2)) + cost[i][color];
            } else if(color == 1){
                dp[i][1] = Math.min(RGB(i-1, 0), RGB(i-1, 2)) + cost[i][color];
            } else if(color == 2){
                dp[i][2] = Math.min(RGB(i-1, 0), RGB(i-1, 1)) + cost[i][color];
            }
        }
        return dp[i][color];
    }

}