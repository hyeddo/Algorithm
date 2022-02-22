package com.ssafy.algo.algo0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SW7465_ChangyongVillage {

    static int N, M, ans;
    static int[] parents, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "2\n" +
                "6 5\n" +
                "1 2\n" +
                "2 5\n" +
                "5 1\n" +
                "3 4\n" +
                "4 6\n" +
                "6 8\n" +
                "1 2\n" +
                "2 5\n" +
                "5 1\n" +
                "3 4\n" +
                "4 6\n" +
                "5 4\n" +
                "2 4\n" +
                "2 3";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            makeSet();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                if(!st.hasMoreTokens()){

                }
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            ans = 0;

            for (int i = 1; i <= N ; i++) {
                if(parents[i] == i) ans++;
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(rank[aRoot] < rank[bRoot]){
            parents[aRoot] = bRoot;
            return;
        }
        if(rank[aRoot] == rank[bRoot])
            rank[bRoot]++;
        parents[bRoot] = aRoot;
    }

    private static int findSet(int a) {
        if(parents[a] == a) return a;
        else return parents[a] = findSet(parents[a]);
    }

    private static void makeSet() {
        parents = new int[N+1];
        rank = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parents[i] = i;
        }
    }
}
