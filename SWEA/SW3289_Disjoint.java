package com.ssafy.algo.algo0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SW3289_Disjoint {

    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "1\n" +
                "7 8\n" +
                "0 1 3\n" +
                "1 1 7\n" +
                "0 7 6\n" +
                "1 7 1\n" +
                "0 3 7\n" +
                "0 4 2\n" +
                "0 1 1\n" +
                "1 1 1\n";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            makeSet();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(in.readLine());
                int oper = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(oper == 1){
                    if(findSet(a) == findSet(b))
                        sb.append(1);
                    else
                        sb.append(0);
                } else{
                    union(a, b);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void makeSet(){
        parents = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int a) {
        if(parents[a] == a) return a;
        else return parents[a] = findSet(parents[a]);
    }

    private static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot != bRoot){
            parents[bRoot] = aRoot;
        }
    }
}
