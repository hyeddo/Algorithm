package com.ssafy.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5656_BreakBricks {

    static int N, W, H;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<Brick> qu;
    static int[] selectedCols;
    static boolean[][] visited;
    static int ans;

    static class Brick {
        int h, w, range;

        public Brick(int h, int w, int range) {
            this.h = h;
            this.w = w;
            this.range = range;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5\n" +
                "3 10 10\n" +
                "0 0 0 0 0 0 0 0 0 0\n" +
                "1 0 1 0 1 0 0 0 0 0\n" +
                "1 0 3 0 1 1 0 0 0 1\n" +
                "1 1 1 0 1 2 0 0 0 9\n" +
                "1 1 4 0 1 1 0 0 1 1\n" +
                "1 1 4 1 1 1 2 1 1 1\n" +
                "1 1 5 1 1 1 1 2 1 1\n" +
                "1 1 6 1 1 1 1 1 2 1\n" +
                "1 1 1 1 1 1 1 1 1 5\n" +
                "1 1 7 1 1 1 1 1 1 1\n" +
                "2 9 10\n" +
                "0 0 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0 0\n" +
                "0 1 0 0 0 0 0 0 0\n" +
                "0 1 0 0 0 0 0 0 0\n" +
                "1 1 0 0 1 0 0 0 0\n" +
                "1 1 0 1 1 1 0 1 0\n" +
                "1 1 0 1 1 1 0 1 0\n" +
                "1 1 1 1 1 1 1 1 0\n" +
                "1 1 3 1 6 1 1 1 1\n" +
                "1 1 1 1 1 1 1 1 1\n" +
                "3 6 7\n" +
                "1 1 0 0 0 0\n" +
                "1 1 0 0 1 0\n" +
                "1 1 0 0 4 0\n" +
                "4 1 0 0 1 0\n" +
                "1 5 1 0 1 6\n" +
                "1 2 8 1 1 6\n" +
                "1 1 1 9 2 1\n" +
                "4 4 15\n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "1 0 0 0 \n" +
                "1 0 0 0 \n" +
                "1 0 0 0 \n" +
                "1 0 0 0 \n" +
                "1 0 5 0 \n" +
                "1 1 1 0 \n" +
                "1 1 1 9 \n" +
                "1 1 1 1 \n" +
                "1 6 1 2 \n" +
                "1 1 1 5 \n" +
                "1 1 1 1 \n" +
                "2 1 1 2 \n" +
                "4 12 15\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                "9 9 9 9 9 9 9 9 9 9 9 9";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            qu = new ArrayDeque<>();
            ans = Integer.MAX_VALUE;
            selectedCols = new int[N];
            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            select(0);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void select(int cnt) {
        if (cnt == N) {
            int[][] temp = new int[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            int curCnt = 0;

            for (int i = 0; i < N; i++) {
                visited = new boolean[H][W];
                bfs(temp, selectedCols[i]);
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (temp[i][j] > 0) curCnt++;
                }
            }

            ans = Math.min(ans, curCnt);
            return;
        }

        for (int i = 0; i < W; i++) {
            selectedCols[cnt] = i;
            select(cnt + 1);
        }
    }

    private static void bfs(int[][] temp, int selectedCol) {
        for (int i = 0; i < H; i++) {
            if (temp[i][selectedCol] > 0) {
                qu.offer(new Brick(i, selectedCol, temp[i][selectedCol]));
                break;
            }
        }

        while (!qu.isEmpty()) {
            Brick curr = qu.poll();
            int nh, nw;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < curr.range; j++) {
                    nh = curr.h + dir[i][0] * j;
                    nw = curr.w + dir[i][1] * j;

                    if (nh >= 0 && nh < H && nw >= 0 && nw < W && !visited[nh][nw]) {
                        visited[nh][nw] = true;
                        qu.offer(new Brick(nh, nw, temp[nh][nw]));
                        temp[nh][nw] = 0;
                    }
                }
            }
        }

        Queue<Integer> tempQu;

        for (int i = 0; i < W; i++) {
            tempQu = new ArrayDeque<>();

            for (int j = H - 1; j >= 0; j--) {
                if (temp[j][i] > 0)
                    tempQu.offer(temp[j][i]);
            }
            for (int j = H - 1; j >= 0; j--) {
                if (!tempQu.isEmpty()) {
                    temp[j][i] = tempQu.poll();
                } else {
                    temp[j][i] = 0;
                }
            }
        }
    }
}
