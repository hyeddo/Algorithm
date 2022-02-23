package com.ssafy.algo.algo0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ16236_BabyShark {

    static int N, size, x, y;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "3\n" +
                "0 0 0\n" +
                "0 0 0\n" +
                "0 9 0";
        in = new BufferedReader(new StringReader(str));

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    x = i;
                    y = j;
                    map[i][j] = 0;
                }
            }
        }
        size = 2;
        find();
    }

    private static void find() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == x && i== y) continue;
                if (map[i][j] > 0 && map[i][j] < size){

                }
            }
        }
    }
}
