package com.ssafy.study04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOj2304_StorehousePolygon {

    static int N, ans;
    static Column[] columns;
    static Stack<Column> stack;

    static class Column implements Comparable<Column> {
        int L, H;

        public Column(int l, int h) {
            L = l;
            H = h;
        }

        @Override
        public int compareTo(Column o) {
            return this.L - o.L;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "7\n" +
                "2 4\n" +
                "11 4\n" +
                "15 8\n" +
                "4 6\n" +
                "5 3\n" +
                "8 10\n" +
                "13 6";
        in = new BufferedReader(new StringReader(str));

        N = Integer.parseInt(in.readLine());
        columns = new Column[N];
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            columns[i] = new Column(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(columns);
        int maxL = 0;
        Column current = columns[0];
        for (int i = 1; i < N; i++) {
            if (current.H <= columns[i].H) {
                ans += (columns[i].L - current.L) * current.H;
                current = columns[i];
                maxL = i;
            }
        }

        current = columns[N - 1];
        for (int i = 0; i < N - maxL; i++) {
            if (current.H <= columns[N - 1 - i].H) {
                ans += (current.L - columns[N - 1 - i].L) * current.H;
                current = columns[N - 1 - i];
            }
        }
        ans += current.H;
        System.out.println(ans);
    }
}
