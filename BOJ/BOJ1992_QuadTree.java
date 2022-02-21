package com.ssafy.algo.algo0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ1992_QuadTree {

    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "8\n" +
                "11110000\n" +
                "11110000\n" +
                "00011100\n" +
                "00011100\n" +
                "11110000\n" +
                "11110000\n" +
                "11110011\n" +
                "11110011";
        in = new BufferedReader(new StringReader(str));
        sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = in.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        pack(N, 0, 0);
        System.out.println(sb);
    }

    private static void pack(int N, int r, int c) {
        if (isPackable(N, r, c)) {
            sb.append(map[r][c]);
            return;
        }

        int nextN = N / 2;
        sb.append("(");
        pack(nextN, r, c);
        pack(nextN, r, c + nextN);
        pack(nextN, r + nextN, c);
        pack(nextN, r + nextN, c + nextN);
        sb.append(")");
    }

    private static boolean isPackable(int N, int r, int c) {
        int val = map[r][c];
        for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (map[i][j] != val)
                    return false;
            }
        }
        return true;
    }
}
