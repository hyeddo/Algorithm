package com.ssafy.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1953_TrackFugitive {

    static int N, M, R, C, L, ans;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;
    static Queue<Pos> qu;
    static int[][] type= {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1}
    };

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5\n" +
                "5 6 2 1 3\n" +
                "0 0 5 3 6 0\n" +
                "0 0 2 0 2 0\n" +
                "3 3 1 3 7 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "5 6 2 2 6\n" +
                "3 0 0 0 0 3\n" +
                "2 0 0 0 0 6\n" +
                "1 3 1 1 3 1\n" +
                "2 0 2 0 0 2\n" +
                "0 0 4 3 1 1\n" +
                "10 10 4 3 9\n" +
                "0 0 0 0 0 0 0 0 0 0\n" +
                "0 0 0 7 5 0 5 0 0 0\n" +
                "0 0 3 2 2 6 0 0 0 0\n" +
                "0 4 7 2 2 2 7 0 0 4\n" +
                "0 3 0 1 1 2 2 0 0 5\n" +
                "0 5 6 1 1 1 1 6 2 5\n" +
                "7 4 1 2 0 0 4 6 0 0\n" +
                "5 3 1 7 0 2 2 6 5 7\n" +
                "7 3 2 1 1 7 1 0 2 7\n" +
                "3 4 0 0 4 0 5 1 0 1\n" +
                "20 20 13 11 13\n" +
                "0 0 0 1 4 4 4 0 0 0 0 0 0 0 0 1 2 3 1 0\n" +
                "0 0 0 0 0 0 0 0 0 0 0 4 2 7 7 2 0 1 1 0\n" +
                "0 0 0 0 0 0 0 0 0 6 2 4 4 2 0 4 7 0 6 0\n" +
                "0 0 0 7 5 5 3 0 0 7 5 0 5 6 4 2 6 3 1 5\n" +
                "0 0 0 1 2 6 3 3 7 0 3 6 2 4 5 6 7 7 5 7\n" +
                "0 0 0 3 7 6 1 5 3 3 4 5 7 6 0 4 3 3 1 1\n" +
                "0 1 2 1 5 6 1 6 1 6 5 1 6 0 0 3 4 1 7 6\n" +
                "0 2 3 2 2 7 3 0 0 3 2 5 2 1 0 6 5 1 6 5\n" +
                "0 2 5 7 0 7 1 3 3 4 1 3 3 0 2 3 3 2 4 1\n" +
                "4 0 0 7 2 4 2 2 1 3 1 6 5 5 6 2 5 1 1 6\n" +
                "5 6 4 0 3 6 5 2 2 6 1 2 0 1 7 5 7 2 2 2\n" +
                "1 6 3 1 4 4 1 0 3 0 4 2 7 2 0 2 3 6 2 5\n" +
                "1 5 7 2 1 1 4 4 2 1 0 2 7 1 6 2 6 6 2 2\n" +
                "3 7 0 6 5 0 4 0 6 6 7 1 3 1 1 1 5 1 6 6\n" +
                "0 4 0 1 6 2 1 0 7 0 4 2 5 2 7 0 2 7 1 6\n" +
                "0 7 3 0 1 7 6 2 0 0 4 2 4 1 3 3 7 0 1 3\n" +
                "0 1 1 4 3 7 4 5 2 2 4 7 4 7 7 4 6 0 1 6\n" +
                "0 5 2 2 1 4 6 3 7 0 6 3 5 0 0 6 4 4 2 1\n" +
                "0 1 2 4 5 6 0 2 0 0 5 6 2 4 6 4 7 6 3 7\n" +
                "7 7 4 2 3 0 0 4 0 0 7 2 7 5 6 1 4 5 5 4\n" +
                "50 50 20 12 18\n" +
                "0 0 0 0 0 0 0 0 0 0 0 0 4 5 0 0 0 0 0 4 2 0 5 2 1 5 3 3 0 0 4 0 5 1 7 2 6 0 7 0 0 0 2 0 0 0 0 0 0 0\n" +
                "6 7 0 0 0 0 0 0 0 0 0 0 4 5 5 3 6 3 0 2 3 3 0 0 5 6 1 5 3 4 7 6 2 2 1 1 6 5 6 4 6 2 0 0 0 0 2 3 1 0\n" +
                "0 2 6 5 7 6 0 0 0 0 0 0 6 2 0 5 6 2 0 4 1 5 0 0 2 0 7 7 0 6 0 6 2 2 4 1 2 2 1 6 6 6 0 2 2 5 0 6 5 0\n" +
                "0 0 0 4 7 2 7 3 7 0 0 0 0 6 7 6 5 1 1 1 2 2 1 3 1 2 7 6 1 2 1 2 4 1 6 1 1 7 3 1 6 6 6 1 1 1 7 0 0 0\n" +
                "0 0 0 5 4 0 6 3 3 7 0 0 0 6 4 3 2 5 3 1 6 1 0 4 1 0 5 7 6 3 1 1 3 6 1 1 6 3 6 7 3 3 6 5 0 7 2 2 4 6\n" +
                "0 6 0 7 6 0 7 4 0 5 3 0 4 3 2 0 5 7 3 0 1 3 6 7 7 5 1 7 5 2 0 5 3 1 3 7 1 1 1 5 2 5 1 3 6 7 7 6 4 3\n" +
                "5 2 0 2 6 5 0 5 6 1 6 5 5 1 7 1 2 3 6 5 1 6 7 7 6 4 1 7 5 2 0 1 3 4 6 4 5 7 2 6 5 6 2 5 6 5 6 5 1 6\n" +
                "1 2 0 7 0 5 5 0 7 6 2 2 1 3 5 5 3 6 3 7 6 4 1 3 1 3 7 0 3 7 0 2 5 6 1 3 4 1 5 1 7 4 1 7 7 0 4 7 5 5\n" +
                "7 6 0 3 5 1 4 0 5 2 5 0 1 3 5 5 4 4 6 1 6 5 7 6 2 1 6 5 5 3 0 5 7 1 1 3 6 2 2 2 4 5 7 4 5 1 1 0 7 3\n" +
                "2 5 4 0 3 1 4 5 6 3 7 0 4 5 3 6 4 5 1 7 4 7 3 1 1 7 7 1 1 5 6 4 7 1 2 6 4 1 7 2 7 1 6 0 5 0 0 0 1 0\n" +
                "3 0 2 5 1 7 1 1 1 6 5 1 3 1 3 1 1 7 1 3 6 5 5 3 1 3 1 6 2 3 2 6 6 1 1 7 5 7 5 7 1 6 0 3 5 1 5 3 0 0\n" +
                "0 0 3 2 0 1 4 1 4 1 0 7 3 2 2 4 2 4 4 6 1 1 1 7 2 4 7 4 3 6 3 5 1 6 1 3 7 7 2 6 3 2 1 0 4 6 2 6 3 0\n" +
                "0 0 5 4 7 2 4 6 4 1 6 7 2 2 1 6 2 1 5 4 7 2 2 1 0 7 6 1 7 2 5 7 0 4 1 6 4 0 3 0 0 5 5 0 7 7 0 3 0 0\n" +
                "0 0 6 4 3 1 3 1 4 7 2 1 2 4 3 4 1 6 2 1 5 1 1 6 0 7 2 7 2 4 7 4 0 3 7 7 3 3 5 2 0 4 3 0 4 2 0 1 3 5\n" +
                "0 1 0 5 6 4 4 6 5 7 0 6 1 4 5 6 2 1 2 4 4 1 1 2 6 1 6 2 0 3 7 3 0 0 5 1 7 6 6 6 1 3 4 2 1 0 7 0 5 5\n" +
                "0 7 2 1 4 2 7 3 0 2 1 4 3 5 1 1 1 1 7 1 4 4 1 7 6 0 1 2 0 5 2 0 0 0 5 4 0 3 7 5 3 1 4 1 2 7 2 6 6 4\n" +
                "0 1 3 0 3 4 6 3 4 2 4 0 7 5 1 1 2 7 1 6 4 2 2 0 5 6 3 3 1 1 0 0 0 3 0 4 5 4 3 1 1 6 1 6 2 0 1 4 7 7\n" +
                "0 3 0 0 2 6 1 4 7 5 1 4 3 2 5 1 4 3 6 3 0 2 4 5 7 5 6 2 0 5 6 3 6 4 6 2 0 0 6 0 7 2 2 6 0 0 0 0 0 0\n" +
                "0 6 7 1 6 4 3 6 0 2 6 7 6 2 1 6 6 6 2 0 0 7 3 0 1 1 2 0 0 0 3 1 6 7 5 6 4 1 7 5 2 0 2 6 0 0 0 0 4 0\n" +
                "0 6 7 7 3 3 0 2 0 1 6 4 1 1 1 6 2 3 3 4 2 3 5 0 5 7 7 6 2 7 2 7 3 1 0 5 6 7 1 6 4 1 5 0 0 0 0 0 0 0\n" +
                "0 7 3 0 4 3 0 0 6 6 0 5 1 1 1 1 1 6 0 0 7 0 0 0 2 4 3 2 3 3 6 0 0 1 0 2 6 7 3 4 0 3 2 4 0 0 0 0 0 7\n" +
                "0 0 4 7 2 0 0 0 1 4 2 4 7 7 2 4 2 4 0 5 6 0 0 0 7 0 2 7 4 4 1 6 1 4 2 3 6 2 0 6 5 3 5 0 3 5 6 0 0 1\n" +
                "0 0 7 4 7 0 3 0 4 4 6 2 4 7 0 5 7 1 3 6 5 6 6 7 3 3 6 6 4 2 0 0 3 0 4 7 2 6 4 0 6 2 4 6 7 1 7 2 7 1\n" +
                "0 0 2 6 0 0 6 5 0 4 1 2 2 2 2 7 2 1 0 4 6 4 1 0 1 1 2 2 0 4 4 2 0 0 3 0 3 6 2 2 7 6 6 0 4 6 0 2 2 2\n" +
                "0 0 4 4 7 1 1 1 7 3 7 6 2 3 3 0 5 0 0 6 1 2 6 3 1 7 0 4 7 4 3 6 1 5 1 0 3 7 4 0 3 0 5 6 2 0 0 3 0 5\n" +
                "0 0 7 3 0 5 4 0 7 4 0 0 4 5 7 1 3 2 3 3 5 3 5 3 5 5 5 5 4 2 3 6 0 3 1 7 2 4 5 3 0 0 5 3 6 0 0 7 3 6\n" +
                "0 0 3 5 0 0 1 1 1 0 0 0 5 3 5 5 1 2 7 0 4 3 1 6 7 1 5 7 4 4 5 7 0 3 6 3 3 7 7 4 1 3 5 2 0 0 0 7 7 4\n" +
                "0 0 7 6 3 5 0 7 2 7 7 5 4 0 0 7 0 4 0 0 3 2 3 1 5 7 4 6 0 3 5 5 2 0 6 0 0 0 2 1 1 4 3 6 2 0 5 1 1 6\n" +
                "0 0 1 0 4 1 0 2 5 0 0 0 6 7 3 7 0 0 0 0 4 3 3 3 0 1 0 0 0 1 5 1 5 4 5 1 7 0 0 5 0 5 6 0 3 2 5 0 3 4\n" +
                "0 0 0 0 0 4 0 2 3 1 6 6 6 3 5 3 6 0 0 0 4 7 0 6 1 7 1 0 0 5 5 2 5 1 0 1 1 3 3 4 1 4 2 0 6 3 0 0 6 4\n" +
                "6 4 2 2 0 0 0 3 3 0 0 1 4 0 5 0 2 0 7 0 1 7 7 1 5 7 0 0 0 3 1 5 5 6 0 6 2 6 4 0 7 6 5 1 3 3 7 0 2 5\n" +
                "0 0 0 7 7 0 0 4 4 3 1 6 1 0 1 3 3 1 4 5 7 3 7 0 0 4 0 0 0 7 3 7 2 2 0 1 5 0 7 5 5 2 5 1 0 2 0 0 3 2\n" +
                "0 0 0 3 0 0 0 0 1 2 6 7 1 6 7 0 3 5 2 7 3 0 4 5 2 0 0 0 0 2 5 7 3 7 5 6 0 0 2 2 5 4 7 6 4 5 1 4 4 6\n" +
                "0 4 3 0 0 0 0 3 5 6 3 2 0 3 6 0 6 0 0 1 4 3 6 2 4 7 4 7 1 5 0 4 0 0 2 0 0 0 3 7 6 1 2 5 3 5 2 3 3 3\n" +
                "0 0 0 1 4 0 0 2 1 0 2 0 0 1 7 3 4 3 3 4 7 0 6 7 4 7 3 1 6 1 7 3 4 4 7 5 2 1 3 7 2 5 2 3 3 2 3 0 1 2\n" +
                "0 0 0 0 1 1 0 0 5 7 3 6 6 0 0 6 5 4 2 7 0 0 4 5 5 0 5 7 3 3 0 3 5 5 3 6 0 0 3 5 4 0 0 7 5 1 6 0 0 7\n" +
                "0 0 0 0 5 6 3 1 5 2 0 7 7 7 0 0 1 0 3 6 4 1 6 7 2 1 6 5 2 0 0 7 4 5 0 0 0 0 0 6 6 0 0 5 6 0 2 3 4 5\n" +
                "0 0 7 1 0 1 6 5 6 0 0 5 4 5 7 1 1 6 5 2 2 0 3 7 4 5 2 6 4 0 0 3 4 0 0 0 0 0 0 7 7 7 7 6 4 3 4 4 0 0\n" +
                "0 0 0 1 3 0 0 3 7 1 1 0 4 1 4 4 2 6 1 6 2 2 7 4 2 4 1 7 1 6 4 3 3 1 3 4 0 0 3 2 0 2 0 1 3 3 4 7 1 5\n" +
                "0 0 0 3 4 0 0 2 0 5 5 0 0 1 4 4 0 4 0 1 6 6 4 2 1 0 0 3 7 0 4 3 3 2 3 5 3 5 0 4 0 5 0 3 0 7 7 3 5 6\n" +
                "0 0 0 7 2 0 0 4 2 2 6 2 2 5 0 5 0 3 4 3 5 5 2 0 4 0 0 5 0 0 4 1 6 4 4 3 4 0 0 5 0 1 1 2 0 7 3 4 0 4\n" +
                "0 0 1 1 4 4 1 0 0 0 3 5 4 5 4 2 7 4 6 1 6 7 0 3 0 7 1 7 6 6 3 0 5 7 6 6 4 7 3 4 5 0 0 0 0 6 1 1 5 3\n" +
                "0 0 4 2 5 7 4 4 2 1 2 1 3 4 7 2 7 2 1 6 3 3 0 7 5 6 6 4 5 5 3 3 2 7 5 3 1 4 7 0 0 0 0 0 0 3 1 5 6 5\n" +
                "0 0 0 4 4 1 0 0 6 0 0 7 5 7 5 1 7 3 6 0 2 4 3 4 7 7 3 0 0 0 1 5 5 0 6 7 7 7 4 4 3 6 3 7 5 0 1 1 0 2\n" +
                "0 0 0 1 3 4 7 2 5 0 0 4 4 0 5 2 2 0 1 7 0 1 1 3 6 5 2 6 2 7 7 3 6 7 1 3 4 6 7 5 3 7 4 6 0 0 0 4 3 1\n" +
                "0 0 0 2 1 6 3 5 4 0 0 6 0 0 6 7 0 0 5 2 0 7 7 0 7 0 0 7 7 6 0 0 1 1 0 1 0 1 3 1 0 0 4 7 7 0 0 0 2 6\n" +
                "0 0 0 2 4 0 6 7 2 4 1 5 6 3 0 0 0 0 4 2 7 1 1 5 2 0 0 7 2 2 3 1 3 5 5 7 7 4 0 3 4 2 3 0 0 4 6 6 0 1\n" +
                "0 0 0 4 6 1 0 3 6 4 7 3 5 0 0 0 0 0 0 7 0 0 3 6 2 1 0 2 3 4 6 7 5 0 7 0 5 4 5 1 5 0 0 0 0 4 5 3 1 0\n" +
                "1 3 6 5 5 2 3 7 6 1 0 6 7 3 2 5 6 7 6 6 0 0 7 1 0 5 5 0 3 0 2 0 7 4 5 3 2 5 1 5 3 0 0 0 1 2 0 1 0 0\n" +
                "1 7 3 0 2 0 7 0 4 6 1 1 5 0 7 0 5 7 7 2 6 0 0 1 0 2 3 3 4 2 7 5 3 7 0 0 4 6 6 6 3 0 0 0 7 7 7 5 7 2\n";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = 0;
            bfs();
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        qu = new ArrayDeque<>();
        qu.offer(new Pos(R, C));
        visited[R][C] = true;
        ans++;

        for (int l = 0; l < L - 1; l++) {
            int size = qu.size();
            for (int k = 0; k < size; k++) {
                Pos curr = qu.poll();

                int[] currDir = type[map[curr.x][curr.y]];
                for (int d = 0; d < currDir.length; d++) {
                    if(currDir[d] == 0) continue;
                    int nextX = curr.x + dir[d][0];
                    int nextY = curr.y + dir[d][1];
                    if(nextX >= 0 && nextX <N && nextY >= 0 && nextY < M && map[nextX][nextY] != 0 && !visited[nextX][nextY]){
                        if(type[map[nextX][nextY]][(d+2)%4] == 1){
                            visited[nextX][nextY] = true;
                            qu.offer(new Pos(nextX, nextY));
                            ans++;
                        }
                    }
                }
            }
        }
    }
}
