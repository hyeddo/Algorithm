package com.ssafy.study03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ2564_SecurityGuard {

    static int row, col, num, sum;
    static int[][] stores;
    static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "10 5\n" +
                "3\n" +
                "1 4\n" +
                "3 2\n" +
                "2 8\n" +
                "2 3";
        in = new BufferedReader(new StringReader(str));

        String[] s = in.readLine().split(" ");
        col = Integer.parseInt(s[0]);
        row = Integer.parseInt(s[1]);
        num = Integer.parseInt(in.readLine());
        sum = 0;
        stores = new int[num + 1][2];
        distances = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            s = in.readLine().split(" ");
            stores[i][0] = Integer.parseInt(s[0]);
            stores[i][1] = Integer.parseInt(s[1]);
            if (stores[i][0] == 1) {
                distances[i] = stores[i][1];
            } else if (stores[i][0] == 2) {
                distances[i] = col * 2 + row - stores[i][1];
            } else if (stores[i][0] == 3) {
                distances[i] = col * 2 + row * 2 - stores[i][1];
            } else {
                distances[i] = col + stores[i][1];
            }
        }

        compute();
        System.out.println(sum);
    }

    private static void compute() {
        for (int i = 0; i < num; i++) {
            int d1 = Math.abs(distances[i] - distances[num]);
            int d2 = col * 2 + row * 2 - d1;
            sum += Math.min(d1, d2);
        }
    }
}
