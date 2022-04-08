package com.ssafy.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SW1249_SupplyRoute {

    static int N, answer;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int[][] ans;

    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            answer = Integer.MAX_VALUE;
            visited = new boolean[N][N];
            ans = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = in.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
            ans[0][0] = 0;
            bfs();
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Pos> qu = new ArrayDeque<>();
        qu.offer(new Pos(0, 0));
        visited[0][0] = true;
        while (!qu.isEmpty()){
            Pos curr = qu.poll();

            if(curr.x == N-1 && curr.y == N -1){
                answer = Math.min(answer, ans[N-1][N-1]);
            }
            if(answer <= ans[curr.x][curr.y])
                continue;
            for (int i = 0; i < 4; i++) {
                Pos next = new Pos(curr.x + dir[i][0], curr.y + dir[i][1]);
                if(next.x >= 0 && next.x < N && next.y >= 0 && next.y < N){
                    if(!visited[next.x][next.y] || ans[next.x][next.y] > ans[curr.x][curr.y] + map[next.x][next.y]){
                        visited[next.x][next.y] = true;
                        ans[next.x][next.y] = ans[curr.x][curr.y] + map[next.x][next.y];
                        qu.offer(new Pos(next.x, next.y));
                    }
                }
            }
        }
    }
}
