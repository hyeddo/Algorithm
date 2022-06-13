package com.ssafy.study15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BOJ1707_BinaryGraph {

    static int K, V, E;
    static List<Integer>[] list;
    static int[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "2\n" +
                "3 2\n" +
                "1 3\n" +
                "2 3\n" +
                "4 4\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 2";
        in = new BufferedReader(new StringReader(str));
        sb = new StringBuilder();

        K = Integer.parseInt(in.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visited = new int[V + 1];
            list = new ArrayList[V + 1];
            for (int j = 0; j <= V; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(in.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list[start].add(end);
                list[end].add(start);
            }
            solve();
        }
        System.out.println(sb);
    }

    private static void solve() {
        Queue<Integer> qu = new ArrayDeque<>();

        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                qu.add(i);
                visited[i] = 1;
            }
            while (!qu.isEmpty()) {
                int curr = qu.poll();

                for (int j = 0; j < list[curr].size(); j++) {
                    if (visited[list[curr].get(j)] == 0) {
                        qu.add(list[curr].get(j));
                    }
                    if (visited[list[curr].get(j)] == visited[curr]) {
                        sb.append("NO").append("\n");
                        return;
                    }
                    if (visited[curr] == 1 && visited[list[curr].get(j)] == 0)
                        visited[list[curr].get(j)] = 2;
                    else if (visited[curr] == 2 && visited[list[curr].get(j)] == 0)
                        visited[list[curr].get(j)] = 1;
                }
            }
        }
        sb.append("YES").append("\n");
    }
}
