package com.ssafy.algo.algo0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class JO1681_HamiltonCycle {

    static int N, ans;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5\n" +
                "0 14 4 10 20 \n" +
                "14 0 7 8 7 \n" +
                "4 5 0 7 16 \n" +
                "11 7 9 0 2 \n" +
                "18 7 17 4 0";
        in = new BufferedReader(new StringReader(str));

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N];
        visited[0] = true;
        ans = Integer.MAX_VALUE;
        dfs(1,0,0);
        System.out.println(ans);
    }

    private static void dfs(int cnt, int curr, int sum) {
        if(sum> ans) return;
        if(cnt == N){
            if(map[curr][0] != 0 && ans > sum+map[curr][0]){
                ans = sum+map[curr][0];
            }
            return;
        }
        for (int i = 1; i < N; i++) {
            if(map[curr][i] == 0 || visited[i]) continue;
            visited[i] = true;
            dfs(cnt+1, i, sum+map[curr][i]);
            visited[i] = false;
        }
    }
}
