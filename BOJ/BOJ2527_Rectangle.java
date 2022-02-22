package com.ssafy.study03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2527_Rectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "3 10 50 60 100 100 200 300\n" +
                "45 50 600 600 400 450 500 543\n" +
                "11 120 120 230 50 40 60 440\n" +
                "35 56 67 90 67 80 500 600";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());


            if((p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2) || (p1 == x2 && y1 == q2) || (x1 == p2 && y1 == q2))
                sb.append("c").append("\n");
            else if((p1 == x2 && q1 != y2) || (x1 == p2 && q1 != y2) || (p1 != x2 && y1 == q2) || (x1 != p2 && y1 == q2))
                sb.append("b").append("\n");
            else if(p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1)
                sb.append("d").append("\n");
            else
                sb.append("a").append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
