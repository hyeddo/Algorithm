package com.ssafy.study16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2660_PresidentElection {

    static int N;
    static final int INF = 987654321;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "2 4\n" +
                "5 3\n" +
                "-1 -1";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        while (true) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == -1 && y == -1) {
                break;
            }

            arr[x][y] = arr[y][x] = 1; // 친구 관계는 양방향
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int readerScore = INF;

        int[] scoreArr = new int[N + 1]; // 친구 점수 목록

        for (int i = 1; i <= N; i++) {
            int score = 0;
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != INF) {
                    score = Math.max(score, arr[i][j]);
                }
            }

            scoreArr[i] = score;
            readerScore = Math.min(readerScore, score);
        }

        sb.append(readerScore).append(" ");
        StringBuilder sb2 = new StringBuilder();
        int readerNum = 0;
        for (int i = 1; i <= N; i++) {
            if (readerScore == scoreArr[i]) {
                readerNum++;
                sb2.append(i).append(" ");
            }
        }
        sb.append(readerNum).append(" ");
        System.out.println(sb);
        System.out.println(sb2);
    }
}
