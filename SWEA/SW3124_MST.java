package com.ssafy.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SW3124_MST {

    static int[] parent;

    static class Edge{
        int s, e, cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "3\n" +
                "2 3\n" +
                "0 1 1\n" +
                "0 2 1\n" +
                "1 2 6\n" +
                "4 7\n" +
                "0 1 9\n" +
                "0 2 3\n" +
                "0 3 7\n" +
                "1 4 2\n" +
                "2 3 8\n" +
                "2 4 1\n" +
                "3 4 8\n" +
                "4 6\n" +
                "0 1 10\n" +
                "0 2 7\n" +
                "1 4 2\n" +
                "2 3 10\n" +
                "2 4 3\n" +
                "3 4 10";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<Edge> edges = new ArrayList<>();
            long ans = 0;
            for (int i = 0; i < E; i++) {
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

            parent = new int[V+1];
            for (int i = 1; i <= V; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < E; i++) {
                Edge edge = edges.get(i);
                if(!isSameParent(edge.s, edge.e)){
                    union(edge.s, edge.e);
                    ans += edge.cost;
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        else
            return false;
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            parent[y] = x;
        }
    }

    private static int find(int x){
        if(parent[x] == x){
            return x;
        } else{
            return parent[x] = find(parent[x]);
        }
    }
}
