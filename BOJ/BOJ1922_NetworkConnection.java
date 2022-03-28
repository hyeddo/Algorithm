package com.ssafy.study06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 48392KB 532ms

public class BOJ1922_NetworkConnection {

    static int[] parent;

    static class Edge {
        int s, e, cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "6\n" +
                "9\n" +
                "1 2 5\n" +
                "1 3 4\n" +
                "2 3 2\n" +
                "2 4 7\n" +
                "3 4 6\n" +
                "3 5 11\n" +
                "4 5 3\n" +
                "4 6 8\n" +
                "5 6 8";
        in = new BufferedReader(new StringReader(str));

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        List<Edge> edges = new ArrayList<>();
        int ans = 0;
        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, cost));
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            Edge edge = edges.get(i);
            if (!isSameParent(edge.s, edge.e)) {
                union(edge.s, edge.e);
                ans += edge.cost;
            }
        }

        System.out.println(ans);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return true;
        else
            return false;
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

}