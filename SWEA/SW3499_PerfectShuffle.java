package com.ssafy.algo.algo0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SW3499_PerfectShuffle {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "3\n" +
                "6\n" +
                "A B C D E F\n" +
                "4\n" +
                "JACK QUEEN KING ACE\n" +
                "5\n" +
                "ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());
            String[] cards = in.readLine().split(" ");

            cards = perfectShuffle(cards, N);

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < N; i++) {
                sb.append(cards[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String[] perfectShuffle(String[] cards, int N) {
        int firstIdx = 0;
        int secondIdx = (N + 1) / 2;
        String[] newCards = new String[N];

        for (int i = 0; i < N / 2; i++) {
            newCards[2 * i] = cards[i];
            newCards[2 * i + 1] = cards[(N + 1) / 2 + i];
        }
        if (N % 2 == 1) newCards[N - 1] = cards[N / 2];
        return newCards;
    }
}
