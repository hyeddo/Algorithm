package com.ssafy.algo.algo0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ2563_ColoredPaper {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "3\n" +
                "1 3\n" +
                "1 4\n" +
                "1 2";
        in = new BufferedReader(new StringReader(str));

        int num = Integer.parseInt(in.readLine());

        int[][] papers = new int[100][100];

        for (int i = 0; i < num; i++) {
            String[] s = in.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    papers[x + j][y + k] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (papers[i][j] == 1)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
