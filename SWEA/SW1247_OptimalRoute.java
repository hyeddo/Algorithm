package com.ssafy.algo.algo0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SW1247_OptimalRoute {

    static int N, cx, cy, hx, hy, ans;
    static int[][] map;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "10\n" +
                "5\n" +
                "0 0 100 100 70 40 30 10 10 5 90 70 50 20\n" +
                "6\n" +
                "88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14\n" +
                "7\n" +
                "22 47 72 42 61 93 8 31 72 54 0 64 26 71 93 87 84 83\n" +
                "8\n" +
                "30 20 43 14 58 5 91 51 55 87 40 91 14 55 28 80 75 24 74 63\n" +
                "9\n" +
                "3 9 100 100 16 52 18 19 35 67 42 29 47 68 59 38 68 81 80 37 94 92\n" +
                "10\n" +
                "39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36\n" +
                "10\n" +
                "26 100 72 2 71 100 29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96\n" +
                "10\n" +
                "46 25 16 6 48 82 80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63\n" +
                "10\n" +
                "94 83 72 42 43 36 59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3\n" +
                "10\n" +
                "32 79 0 0 69 58 100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86\n";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());
            hx = Integer.parseInt(st.nextToken());
            hy = Integer.parseInt(st.nextToken());
            map = new int[N + 2][2];
            for (int i = 1; i < N + 1; i++) {
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }
            map[0] = new int[]{cx, cy};
            map[N+1] = new int[]{hx, hy};

            ans = Integer.MAX_VALUE;
            isVisited = new boolean[N + 1];
            perm(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static void perm(int cnt, int prev, int dist) {
        if (dist >= ans) return;
        if (cnt == N) {
            dist += Math.abs(map[prev][0]-map[N+1][0]) + Math.abs(map[prev][1] - map[N+1][1]);
            ans = Math.min(dist, ans);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                perm(cnt + 1, i, dist + Math.abs(map[prev][0]-map[i][0]) + Math.abs(map[prev][1] - map[i][1]));
                isVisited[i] = false;
            }
        }
    }
}
