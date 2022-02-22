package com.ssafy.study03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2578_Bingo {

    static int[][] chulsoo, bingo;
    static int[] lines;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "11 12 2 24 10\n" +
                "16 1 13 3 25\n" +
                "6 20 5 21 17\n" +
                "19 4 8 14 9\n" +
                "22 15 7 23 18\n" +
                "5 10 7 16 2\n" +
                "4 22 8 17 13\n" +
                "3 18 1 6 25\n" +
                "12 19 23 14 21\n" +
                "11 24 9 20 15";
        in = new BufferedReader(new StringReader(str));

        chulsoo = new int[5][5];
        bingo = new int[5][5];
        lines = new int[12];
        cnt = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 5; j++) {
                chulsoo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
                if (isBingo(bingo[i][j])) {
                    System.out.println(5 * i + j + 1);
                    return;
                }
            }
        }
    }

    private static boolean isBingo(int num) {
        int tr = 0, tc = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (chulsoo[i][j] == num) {
                    tr = i;
                    tc = j;
                    break;
                }
            }
            if (chulsoo[tr][tc] == num)
                break;
        }

        if (++lines[tr] == 5) {
            cnt++;
        }
        if (++lines[5 + tc] == 5) {
            cnt++;
        }
        if (tr == tc) {
            if (++lines[10] == 5) {
                cnt++;
            }
        }
        if (tr + tc == 4) {
            if (++lines[11] == 5) {
                cnt++;
            }
        }
        if (cnt >= 3) {
            return true;
        }
        return false;
    }
}
