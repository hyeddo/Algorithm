package com.ssafy.study04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ10163_ColoredPaper {

    static int N;
    static Paper[] papers;
    static int[][] map;

    static class Paper{
        int x, y, width, height;

        public Paper(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "4\n" +
                "0 2 10 10\n" +
                "7 9 8 4\n" +
                "8 4 10 6\n" +
                "6 0 12 10";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(in.readLine());
        papers = new Paper[N + 1];
        map = new int[1001][1001];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            papers[i] = new Paper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int j = papers[i].x; j < papers[i].x + papers[i].width; j++) {
                for (int k = papers[i].y; k < papers[i].y + papers[i].height; k++) {
                    map[j][k] = i;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 0; j < 1001; j++) {
                for (int k = 0; k < 1001; k++) {
                    if(map[j][k] == i){
                        temp++;
                    }
                }
            }
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }
}
