package com.ssafy.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class SW5643_Height {

    static int N, M;
    static int tallCnt, shortCnt, ans;
    static int[][] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "1\n" +
                "6\n" +
                "6\n" +
                "1 5\n" +
                "3 4\n" +
                "5 4\n" +
                "4 2\n" +
                "4 6\n" +
                "5 2";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            M = Integer.parseInt(in.readLine());
            StringTokenizer st = null;
            adj = new int[N+1][N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                adj[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            ans = 0;
            for (int i = 1; i <= N; i++) {
                tallCnt = 0;
                shortCnt = 0;
                tallBfs(i);
                shortBfs(i);
                if(tallCnt + shortCnt == N - 1)
                    ans++;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void shortBfs(int start) {
        visited = new boolean[N + 1];
        Queue<Integer> qu = new ArrayDeque<>();
        qu.offer(start);
        visited[start] = true;
        while (!qu.isEmpty()) {
            int curr = qu.poll();
            for (int i = 1; i <= N; i++) {
                if (adj[i][curr] == 1 && !visited[i]) {
                    qu.offer(i);
                    visited[i] = true;
                    shortCnt++;
                }
            }
        }
    }

    private static void tallBfs(int start) {
        visited = new boolean[N + 1];
        Queue<Integer> qu = new ArrayDeque<>();
        qu.offer(start);
        visited[start] = true;
        while (!qu.isEmpty()) {
            int curr = qu.poll();
            for (int i = 1; i <= N; i++) {
                if (adj[curr][i] == 1 && !visited[i]) {
                    qu.offer(i);
                    visited[i] = true;
                    tallCnt++;
                }
            }
        }
    }
}
