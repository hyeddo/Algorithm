package com.ssafy.study05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569_Tomato {

    static class Pos {
        int x, y, z;

        public Pos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int M, N, H, days;
    static int[][][] tomatoes;
    static Queue<Pos> qu;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5 3 2\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 1 0 0\n" +
                "0 0 0 0 0";
        in = new BufferedReader(new StringReader(str));

        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[H][N][M];
        qu = new ArrayDeque<>();
        int notRipe = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(in.readLine());
                for (int k = 0; k < M; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        qu.offer(new Pos(k, j, i));
                    } else if (tomatoes[i][j][k] == 0)
                        notRipe++;
                }
            }
        }

        if (notRipe == 0) {
            System.out.println(0);
        } else {
            days = 0;
            bfs();
            System.out.println(days);
        }
    }

    private static void bfs() {
        while (!qu.isEmpty()) {
            Pos temp = qu.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];
                int nextZ = temp.z + dz[i];
                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && nextZ >= 0 && nextZ < H && tomatoes[nextZ][nextY][nextX] == 0) {
                    tomatoes[nextZ][nextY][nextX] = tomatoes[temp.z][temp.y][temp.x] + 1;
                    qu.offer(new Pos(nextX, nextY, nextZ));
                }
            }
        }

        boolean isDone = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        days = -1;
                        isDone = true;
                        break;
                    } else if (tomatoes[i][j][k] != -1) {
                        days = Math.max(days, tomatoes[i][j][k] - 1);
                    }
                }
                if (isDone)
                    break;
            }
            if (isDone)
                break;
        }
    }
}
