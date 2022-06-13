package com.ssafy.study15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206_CrushWalls {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Pos {
        int x, y, cnt;
        boolean crushed;

        Pos(int x, int y, int cnt, boolean crushed) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.crushed = crushed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "8 8\n" +
                "01000100\n" +
                "01010100\n" +
                "01010100\n" +
                "01010100\n" +
                "01010100\n" +
                "01010100\n" +
                "01010100\n" +
                "00010100";
        in = new BufferedReader(new StringReader(str));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = in.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M][2];
        solve();
    }

    private static void solve() {
        Queue<Pos> qu = new ArrayDeque<>();
        qu.add(new Pos(0, 0, 1, false));
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        while (!qu.isEmpty()) {
            Pos curr = qu.poll();
            if (curr.x == N - 1 && curr.y == M - 1) {
                System.out.println(curr.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dir[i][0];
                int ny = curr.y + dir[i][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int nCnt = curr.cnt + 1;
                    if (map[nx][ny] == 0) {
                        if (!curr.crushed && !visited[nx][ny][0]) {
                            qu.add(new Pos(nx, ny, nCnt, false));
                            visited[nx][ny][0] = true;
                        } else if (curr.crushed && !visited[nx][ny][1]) {
                            qu.add(new Pos(nx, ny, nCnt, true));
                            visited[nx][ny][1] = true;
                        }
                    } else {
                        if (!curr.crushed) {
                            qu.add(new Pos(nx, ny, nCnt, true));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
