package com.ssafy.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2239_Sudoku {

    static int[][] map;
    static List<int[]> list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "103000509\n" +
                "002109400\n" +
                "000704000\n" +
                "300502006\n" +
                "060000050\n" +
                "700803004\n" +
                "000401000\n" +
                "009205800\n" +
                "804000107";
        in = new BufferedReader(new StringReader(str));

        map = new int[9][9];
        list = new ArrayList<int[]>();
        for (int i = 0; i < 9; i++) {
            String s = in.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) - '0';
                if (map[i][j] == 0) list.add(new int[]{i, j});
            }
        }

        sb = new StringBuilder();
        dfs(0);
    }

    private static void dfs(int cnt) {
        if (cnt == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        int r = list.get(cnt)[0];
        int c = list.get(cnt)[1];

        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (map[r][i] != 0)
                check[map[r][i]] = true;
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][c] != 0)
                check[map[i][c]] = true;
        }

        for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
            for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
                if (map[i][j] != 0)
                    check[map[i][j]] = true;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (!check[i]) {
                map[r][c] = i;
                dfs(cnt + 1);
                map[r][c] = 0;
            }
        }
    }
}
