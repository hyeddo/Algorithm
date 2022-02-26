package com.ssafy.study04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2116_DiceStack {

    static int diceNum;
    static int[][] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5\n" +
                "2 3 1 6 5 4\n" +
                "3 1 2 4 6 5\n" +
                "5 6 4 1 3 2\n" +
                "1 3 6 2 4 5\n" +
                "4 1 6 5 2 3";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        diceNum = Integer.parseInt(in.readLine());
        dice = new int[diceNum][6];
        for (int i = 0; i < diceNum; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        int top = 0;
        int bottom = 0;
        for (int i = 1; i <= 6; i++) {
            int temp = 0;
            for (int j = 0; j < diceNum; j++) {
                if (j == 0) {
                    top = i;
                    bottom = findOpposite(j, top);
                } else {
                    bottom = top;
                    top = findOpposite(j, top);
                }
                temp += findMax(top, bottom, j);
            }
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }

    private static int findMax(int top, int bottom, int num) {
        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (dice[num][i] != top && dice[num][i] != bottom) {
                if (max < dice[num][i])
                    max = dice[num][i];
            }
        }
        return max;
    }

    private static int findOpposite(int num, int bottom) {
        int idx = 0;
        int result = 0;
        for (int i = 0; i < 6; i++) {
            if (dice[num][i] == bottom) {
                idx = i;
                break;
            }
        }
        switch (idx) {
            case 0:
            case 5:
                result = dice[num][5 - idx];
                break;
            case 1:
            case 3:
                result = dice[num][4 - idx];
                break;
            case 2:
            case 4:
                result = dice[num][6 - idx];
                break;
        }
        return result;
    }
}
