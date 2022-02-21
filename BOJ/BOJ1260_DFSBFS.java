package com.ssafy.algo.algo0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260_DFSBFS {

    static int N, M, V;
    static int[][] nodes;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "4 5 1\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "2 4\n" +
                "3 4";
        in = new BufferedReader(new StringReader(str));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        nodes = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[x][y] = nodes[y][x] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs();

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> qu = new ArrayDeque<>();
        qu.offer(V);
        visited[V] = true;
        sb.append(V).append(" ");

        while (!qu.isEmpty()) {
            int temp = qu.poll();

            for (int i = 1; i <= N; i++) {
                if(!visited[i] && nodes[temp][i] == 1){
                    qu.offer(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        sb.append(idx).append(" ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && nodes[idx][i] == 1) {
                dfs(i);
            }
        }
    }
}
