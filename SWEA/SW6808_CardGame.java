package com.ssafy.algo.algo0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SW6808_CardGame {
    private static int[] gyuCard;
    private static int[] inCard;
    private static int[] temp;
    private static boolean[] gyu;
    private static boolean[] isChecked;

    private static int win;
    private static int lose;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "4\n" +
                "1 3 5 7 9 11 13 15 17\n" +
                "18 16 14 12 10 8 6 4 2\n" +
                "13 17 9 5 18 7 11 1 15\n" +
                "1 6 7 9 12 13 15 17 18";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] s = in.readLine().split(" ");
            gyuCard = new int[9];
            inCard = new int[9];
            gyu = new boolean[19];
            for (int i = 0; i < 9; i++) {
                gyuCard[i] = Integer.parseInt(s[i]);
                gyu[gyuCard[i]] = true;
            }

            int index = 0;
            for (int i = 1; i <= 18; i++) {
                if (!gyu[i]) {
                    inCard[index++] = i;
                }
            }

            temp = new int[9];
            isChecked = new boolean[9];
            win = 0; lose = 0;
            perm(0);

            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }

    private static void perm(int idx) {
        if (idx == 9) {
            int gScore = 0;
            int iScore = 0;
            for (int i = 0; i < 9; i++) {
                if (gyuCard[i] > temp[i]) {
                    gScore += gyuCard[i] + temp[i];
                } else {
                    iScore += gyuCard[i] + temp[i];
                }
            }
            if (gScore > iScore) win++;
            else if (gScore < iScore) lose++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if(!isChecked[i]){
                temp[idx] = inCard[i];
                isChecked[i] = true;
                perm(idx + 1);
                isChecked[i] = false;
            }
        }
    }
}
