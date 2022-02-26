package com.ssafy.study04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2669_FourRectangles {

    static Rectangle[] rects;
    static int ans;
    static int[][] map;

    static class Rectangle {
        int x1, y1, x2, y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "1 2 4 4\n" +
                "2 3 5 7\n" +
                "3 1 6 5\n" +
                "7 3 8 6";
        in = new BufferedReader(new StringReader(str));

        StringTokenizer st = null;
        rects = new Rectangle[4];
        map = new int[100][100];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(in.readLine());
            rects[i] = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int j = rects[i].x1; j < rects[i].x2; j++) {
                for (int k = rects[i].y1; k < rects[i].y2; k++) {
                    map[j][k] = 1;
                }
            }
        }
        ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j] == 1)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
