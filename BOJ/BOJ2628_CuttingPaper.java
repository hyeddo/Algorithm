package com.ssafy.study04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2628_CuttingPaper {

    static int row, col, dotNum;
    static Line[] lines;

    static class Line implements Comparable<Line> {
        int dir, length;

        public Line(int dir, int length) {
            this.dir = dir;
            this.length = length;
        }

        @Override
        public int compareTo(Line o) {
            if (this.dir == o.dir)
                return this.length - o.length;
            return this.dir - o.dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "10 8\n" +
                "3\n" +
                "0 3\n" +
                "1 4\n" +
                "0 2";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        dotNum = Integer.parseInt(in.readLine());
        lines = new Line[dotNum];
        for (int i = 0; i < dotNum; i++) {
            st = new StringTokenizer(in.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lines);

        int curRowDiff = 0;
        int curColDiff = 0;
        int maxRowDiff = 0;
        int maxColDiff = 0;
        for (int i = 0; i < dotNum; i++) {
            if (lines[i].dir == 0) {
                if (i == 0) {
                    maxRowDiff = lines[i].length;
                }
                if (i + 1 < dotNum && lines[i + 1].dir == 0) {
                    curRowDiff = lines[i + 1].length - lines[i].length;
                    maxRowDiff = Math.max(curRowDiff, maxRowDiff);
                } else {
                    curRowDiff = row - lines[i].length;
                    maxRowDiff = Math.max(curRowDiff, maxRowDiff);
                }
            } else {
                if (i == 0 || lines[i - 1].dir == 0) {
                    maxColDiff = lines[i].length;
                }
                if (i + 1 < dotNum) {
                    curColDiff = lines[i + 1].length - lines[i].length;
                    maxColDiff = Math.max(curColDiff, maxColDiff);
                } else {
                    curColDiff = col - lines[i].length;
                    maxColDiff = Math.max(curColDiff, maxColDiff);
                }
            }
        }
        if(maxColDiff == 0)
            maxColDiff = col;
        if(maxRowDiff == 0)
            maxRowDiff = row;

        System.out.println(maxRowDiff * maxColDiff);
    }
}
