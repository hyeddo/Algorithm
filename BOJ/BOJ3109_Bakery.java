package com.ssafy.algo.algo0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ3109_Bakery {

    static int R, C, ans;
    static char[][] map;
    static boolean isDone;

    static int[] dir = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "6 10\n" +
                "..x.......\n" +
                ".....x....\n" +
                ".x....x...\n" +
                "...x...xx.\n" +
                "..........\n" +
                "....x.....";
        in = new BufferedReader(new StringReader(str));

        String[] s = in.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        ans = 0;
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String string = in.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = string.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            isDone = false;
            setPipe(i, 0);
        }

        System.out.println(ans);
    }

    public static void setPipe(int r, int c) {
        if (c == C - 1) {
            ans++;
            isDone = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nr = r + dir[i];
            int nc = c + 1;
            if(nr >= 0 && nr < R && isAvailable(nr, nc)) {
                map[nr][nc] = ',';
                setPipe(nr, nc);
                if(isDone) return;
            }
        }
    }

    public static boolean isAvailable(int nr, int nc) {
        if (map[nr][nc] == '.') {
            return true;
        }
        return false;
    }
}
