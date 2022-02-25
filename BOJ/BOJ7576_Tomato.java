package com.ssafy.algo.algo0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576_Tomato {

    static int M, N;
    static int[][] tomato;
    static Queue<Tomato> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Tomato {
        int x, y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "6 4\n" +
                "1 -1 0 0 0 0\n" +
                "0 -1 0 0 0 0\n" +
                "0 0 0 0 -1 0\n" +
                "0 0 0 0 -1 1";
        in = new BufferedReader(new StringReader(str));

        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        if (queue.isEmpty()) {
            return -1;
        } else if (queue.size() == N * M) {
            return 0;
        }

        while (!queue.isEmpty()) {
            Tomato temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && tomato[nextX][nextY] == 0) {
                    queue.offer(new Tomato(nextX, nextY));
                    tomato[nextX][nextY] = tomato[temp.x][temp.y] + 1;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    return -1;
                }
                ans = Math.max(ans, tomato[i][j]);
            }
        }
        return ans - 1;
    }
}
