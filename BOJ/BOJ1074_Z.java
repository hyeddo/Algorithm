package com.ssafy.algo.algo0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ1074_Z {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "15 0 0";
        in = new BufferedReader(new StringReader(str));

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int length = (int) Math.pow(2, N);
        compute(length, r, c);
        System.out.println(result);
    }

    private static void compute(int length, int r, int c) {
        if (length == 1) {
            return;
        }

        if (r < length / 2 && c < length / 2) {
            compute(length / 2, r, c);
        } else if (r < length / 2 && c >= length / 2) {
            result += length * length / 4;
            compute(length / 2, r, c - length / 2);
        } else if (r >= length / 2 && c < length / 2) {
            result += length * length / 2;
            compute(length / 2, r - length / 2, c);
        } else {
            result += length * length / 4 * 3;
            compute(length / 2, r - length / 2, c - length / 2);
        }
    }
}
