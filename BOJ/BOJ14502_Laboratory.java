package com.ssafy.study05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BOJ14502_Laboratory {

    static int N, M, ans, maxV;
    static boolean isStop;
    static int[][] map;
    static Queue<Pos> qu;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "7 7\n" +
                "2 0 0 0 1 1 0\n" +
                "0 0 1 0 1 2 0\n" +
                "0 1 1 0 1 0 0\n" +
                "0 1 0 0 0 0 0\n" +
                "0 0 0 0 0 1 1\n" +
                "0 1 0 0 0 0 0\n" +
                "0 1 0 0 0 0 0";
        in = new BufferedReader(new StringReader(str));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MIN_VALUE;
        dfs(0);

        System.out.println(ans);
    }

    private static void dfs(int wallCnt){
        if(wallCnt == 3){
            maxV = 0;
            isStop = false;
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wallCnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        int virusCnt = 0;
        int[][] copy = new int[N][M];
        qu = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
                if(map[i][j] == 2){
                    virusCnt++;
                    qu.offer(new Pos(i, j));
                }
            }
        }

        while(!qu.isEmpty()){
            if(maxV != 0 && virusCnt > maxV) {
                isStop = true;
                break;
            }
            Pos temp = qu.poll();
            System.out.println(temp.x + " " + temp.y);

            for (int i = 0; i < 4; i++) {
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && copy[nextX][nextY] == 0){
                    copy[nextX][nextY] = 2;
                    qu.offer(new Pos(nextX, nextY));
                    virusCnt++;
                }
            }
        }

        int cnt = 0;
        if(!isStop){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(copy[i][j] == 0){
                        cnt++;
                    }
                }
            }
        } else{
            maxV = Math.max(maxV, virusCnt);
        }

        System.out.println(cnt);
        ans = Math.max(cnt, ans);
    }
}
