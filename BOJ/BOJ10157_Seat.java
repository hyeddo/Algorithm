package com.ssafy.study03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ10157_Seat {

    static int C, R, K;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "100 100\n" +
                "3000";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(in.readLine());

        if(K > C*R) {
            System.out.println(0);
            return;
        }

        map = new int[C][R];
        int curX = 0;
        int curY = 0;
        int d = 0;
        for (int i = 0; i < K - 1; i++) {
            map[curX][curY] = 1;
            int nextX = curX + dx[d%4];
            int nextY = curY + dy[d%4];
            if(nextX<0 || nextX>=C || nextY<0 || nextY >=R || map[nextX][nextY] == 1){
                d++;
            }
            curX += dx[d%4];
            curY += dy[d%4];
        }
        sb.append(curX + 1).append(" ").append(curY + 1);
        System.out.println(sb);
    }
}
