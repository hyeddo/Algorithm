package com.ssafy.algo.algo0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ3040_SnowWhiteSevenDwarfs {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "7\n" +
                "8\n" +
                "10\n" +
                "13\n" +
                "15\n" +
                "19\n" +
                "20\n" +
                "23\n" +
                "25";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int[] dwarfs = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(in.readLine());
            sum += dwarfs[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if ((sum - dwarfs[i] - dwarfs[j]) == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            sb.append(dwarfs[k]).append("\n");
                        }
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
