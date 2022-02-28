package com.ssafy.study04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ14696_Ttakji {
    static int N, a, b;
    static int[] aCards, bCards;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5\n" +
                "1 4\n" +
                "4 3 3 2 1\n" +
                "5 2 4 3 2 1\n" +
                "4 4 3 3 1\n" +
                "4 3 2 1 1\n" +
                "4 2 3 2 1\n" +
                "4 4 3 2 1\n" +
                "3 4 3 2\n" +
                "5 4 4 2 3 1\n" +
                "5 4 2 4 1 3";
        in = new BufferedReader(new StringReader(str));
        sb = new StringBuilder();

        N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            aCards = new int[5];
            for (int j = 0; j < a; j++) {
                aCards[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(in.readLine());
            b = Integer.parseInt(st.nextToken());
            bCards = new int[5];
            for (int j = 0; j < b; j++) {
                bCards[Integer.parseInt(st.nextToken())]++;
            }

            game();
        }
        System.out.println(sb);
    }

    private static void game() {
        for (int i = 4; i > 0; i--) {
            if(aCards[i] > bCards[i]){
                sb.append("A").append("\n");
                break;
            } else if(aCards[i] < bCards[i]){
                sb.append("B").append("\n");
                break;
            }
            if(i == 1 && aCards[i] == bCards[i]){
                sb.append("D").append("\n");
                break;
            }
        }
    }
}
