package com.ssafy.study08;

//29368KB / 772ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ11066_CombineFiles {

    static int K, ans;
    static int[][] dp;
    static int[] file, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "2\n" +
                "4\n" +
                "40 30 30 50\n" +
                "15\n" +
                "1 21 3 4 5 35 5 4 3 5 98 21 14 17 32";
        in = new BufferedReader(new StringReader(str));

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            K = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            file = new int[K + 1];
            sum = new int[K + 1];
            for (int i = 1; i <= K; i++) {
                file[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + file[i];
            }

            dp = new int[K + 1][K + 1];
            for (int i = 1; i <= K; i++) {
                for (int j = 1; j + i <= K; j++) {
                    int to = j+i;
                    dp[j][to] = Integer.MAX_VALUE;
                    for (int point = j; point < to; point++) {
                        dp[j][to] = Math.min(dp[j][to], dp[j][point] + dp[point + 1][to] + sum[to] - sum[j - 1]);
                    }
                }
            }
            System.out.println(dp[1][K]);
        }
    }
}
