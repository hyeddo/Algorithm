package com.ssafy.study09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11559_PuyoPuyo {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static Queue<Pos> q;
    static int ans;

    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                ".Y....\n" +
                ".YG...\n" +
                "RRYG..\n" +
                "RRYGG.";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = null;
        map = new char[12][6];
        q = new ArrayDeque<>();
        for (int i = 0; i < 12; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 6; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] != '.'){
                    q.offer(new Pos(i, j));
                }
            }
        }

        compute();
    }

    private static void compute() {
        while (!q.isEmpty()){
            Pos curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dir[i][0];
                int ny = curr.y + dir[i][1];
                if(nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && map[nx][ny] == map[curr.x][curr.y]){
                    q.offer(new Pos(nx, ny));
                }
            }
        }

        compact();
    }

    private static void compact() {
        Queue<Character> qu = new ArrayDeque<>();

        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                qu.offer(map[j][i]);
            }
            int cnt = qu.size();
            for (int j = 0; j < qu.size(); j++) {
                map[11 - j][i] = qu.poll();
            }
            for (int j = cnt; j < 12; j++) {
                map[11 - j][i] = '.';
            }
        }
    }
}
