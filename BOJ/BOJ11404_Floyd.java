package com.ssafy.study16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ11404_Floyd {

    static int n, m;
    static int[][] dist;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5\n" +
                "14\n" +
                "1 2 2\n" +
                "1 3 3\n" +
                "1 4 1\n" +
                "1 5 10\n" +
                "2 4 2\n" +
                "3 4 1\n" +
                "3 5 1\n" +
                "4 5 3\n" +
                "3 5 10\n" +
                "3 1 8\n" +
                "1 4 2\n" +
                "5 1 7\n" +
                "3 4 2\n" +
                "5 2 4";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF)
                    dist[i][j] = 0;

                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
