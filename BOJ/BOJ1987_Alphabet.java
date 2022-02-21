package com.ssafy.algo.algo0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1987_Alphabet {

    static int R, C, ans;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Character> alphabets;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "3 6\n" +
                "HFDFFB\n" +
                "AJHGDH\n" +
                "DGAGEH";
        in = new BufferedReader(new StringReader(str));

        String s = in.readLine();
        R = Integer.parseInt(s.split(" ")[0]);
        C = Integer.parseInt(s.split(" ")[1]);
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            s = in.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        ans = 0;
        alphabets = new ArrayList<>();
        alphabets.add(map[0][0]);
        move(0, 0, 1);

        System.out.println(ans);
    }

    private static void move(int r, int c, int cnt) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if(nr >= 0 && nr <R && nc >= 0 &&nc <C && isAvailable(nr, nc)){
                alphabets.add(map[nr][nc]);
                move(nr, nc, cnt+1);
                alphabets.remove(alphabets.size() - 1);
            }
        }
        if(cnt > ans){
            ans = cnt;
        }
    }

    private static boolean isAvailable(int nr, int nc) {
        if(alphabets.contains(map[nr][nc])){
            return false;
        }
        return true;
    }
}
