package com.ssafy.algo.algo0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW5644_WirelessCharge {

    static int M, A, answer;
    static int[] moveA, moveB;
    static int[][] map;
    static BC[] bcs;

    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};

    public static class BC {
        int x, y, c, p;

        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }

        boolean isInBC(int curX, int curY) {
            if (Math.abs(x - curX) + Math.abs(y - curY) <= c)
                return true;
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5\n" +
                "20 3\n" +
                "2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3\n" +
                "4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3\n" +
                "4 4 1 100\n" +
                "7 10 3 40\n" +
                "6 3 2 70\n" +
                "40 2\n" +
                "0 3 0 3 3 2 2 1 0 4 1 3 3 3 0 3 4 1 1 3 2 2 2 2 2 0 2 3 2 2 3 4 4 3 3 3 2 0 4 4 \n" +
                "0 1 0 3 4 0 4 0 0 1 1 1 0 1 4 4 4 4 4 3 3 3 0 1 0 4 3 2 1 4 4 3 2 3 2 2 0 4 2 1 \n" +
                "5 2 4 140\n" +
                "8 3 3 490\n" +
                "60 4\n" +
                "0 3 3 3 0 1 2 2 2 1 2 2 3 3 4 4 0 3 0 1 1 2 2 3 2 2 3 2 2 0 3 0 1 1 1 4 1 2 3 3 3 3 3 1 1 4 3 2 0 4 4 4 3 4 0 3 3 0 3 4 \n" +
                "1 1 4 1 1 1 1 1 1 4 4 1 2 2 3 2 4 0 0 0 4 3 3 4 3 3 0 1 0 4 3 0 4 3 2 3 2 1 2 2 3 4 0 2 2 1 0 0 1 3 3 1 4 4 3 0 1 1 1 1 \n" +
                "6 9 1 180\n" +
                "9 3 4 260\n" +
                "1 4 1 500\n" +
                "1 3 1 230\n" +
                "80 7\n" +
                "2 2 2 2 2 2 0 2 2 0 4 0 2 3 3 2 3 3 0 3 3 3 4 3 3 2 1 1 1 0 4 4 4 1 0 2 2 2 1 1 4 1 2 3 4 4 3 0 1 1 0 3 4 0 1 2 2 2 1 1 3 4 4 4 4 4 4 3 2 1 4 4 4 4 3 3 3 0 3 3 \n" +
                "4 4 1 1 2 1 2 3 3 3 4 4 4 4 4 1 1 1 1 1 1 1 1 0 3 3 2 0 4 0 1 3 3 3 2 2 1 0 3 2 3 4 1 0 1 2 2 3 2 0 4 0 3 4 1 1 0 0 3 2 0 0 4 3 3 4 0 4 4 4 4 0 3 0 1 1 4 4 3 0 \n" +
                "4 3 1 170\n" +
                "10 1 3 240\n" +
                "10 5 3 360\n" +
                "10 9 3 350\n" +
                "9 6 2 10\n" +
                "5 1 4 350\n" +
                "1 8 2 450\n" +
                "100 8\n" +
                "2 2 3 2 0 2 0 3 3 1 2 2 2 2 3 3 0 4 4 3 2 3 4 3 3 2 3 4 4 4 2 2 2 0 2 2 4 4 4 4 1 1 1 2 2 2 4 3 0 2 3 3 4 0 0 1 1 4 1 1 1 1 2 2 1 1 3 3 3 0 3 2 3 3 0 1 3 3 0 1 1 3 3 4 0 4 1 1 2 2 4 0 4 1 1 2 2 1 1 1 \n" +
                "4 4 4 0 4 1 1 4 1 1 1 1 3 2 1 2 1 1 4 4 1 0 2 3 4 4 4 4 4 0 1 0 2 2 2 0 2 2 2 2 2 2 3 0 0 1 4 3 3 2 0 0 4 4 4 0 2 0 4 1 1 2 2 0 4 4 0 0 2 0 2 3 3 0 2 3 0 3 4 0 4 3 4 4 3 4 1 1 2 2 2 0 0 1 0 4 1 1 1 4 \n" +
                "3 4 2 340\n" +
                "10 1 1 430\n" +
                "3 10 4 10\n" +
                "6 3 4 400\n" +
                "7 4 1 80\n" +
                "4 5 1 420\n" +
                "4 1 2 350\n" +
                "8 4 4 300\n";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            StringTokenizer stA = new StringTokenizer(in.readLine());
            StringTokenizer stB = new StringTokenizer(in.readLine());
            moveA = new int[M+1];
            moveB = new int[M+1];
            answer = 0;
            for (int i = 1; i <= M; i++) {
                moveA[i] = Integer.parseInt(stA.nextToken());
                moveB[i] = Integer.parseInt(stB.nextToken());
            }

            bcs = new BC[A];
            for (int i = 0; i < A; i++) {
                StringTokenizer stAp = new StringTokenizer(in.readLine());
                bcs[i] = new BC(Integer.parseInt(stAp.nextToken()), Integer.parseInt(stAp.nextToken()), Integer.parseInt(stAp.nextToken()), Integer.parseInt(stAp.nextToken()));
            }

            charge();
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void charge() {
        int ax = 1, ay = 1;
        int bx = 10, by = 10;
        for (int i = 0; i <= M; i++) {
            ax += dx[moveA[i]];
            ay += dy[moveA[i]];
            bx += dx[moveB[i]];
            by += dy[moveB[i]];
            List<Integer> alist = new ArrayList<>();
            List<Integer> blist = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                if (bcs[j].isInBC(ax, ay)) {
                    alist.add(j);
                }
                if (bcs[j].isInBC(bx, by)) {
                    blist.add(j);
                }
            }
            answer += computeMax(alist, blist);
        }
    }

    private static int computeMax(List<Integer> alist, List<Integer> blist) {
        int max = 0;
        if (alist.size() == 0 || blist.size() == 0) {
            for (int i = 0; i < alist.size(); i++) {
                if (max < bcs[alist.get(i)].p) max = bcs[alist.get(i)].p;
            }
            for (int i = 0; i < blist.size(); i++) {
                if (max < bcs[blist.get(i)].p) max = bcs[blist.get(i)].p;
            }
        } else {
            for (int i = 0; i < alist.size(); i++) {
                int aBC = alist.get(i);
                for (int j = 0; j < blist.size(); j++) {
                    int bBC = blist.get(j);
                    int temp = 0;
                    if (aBC == bBC) {
                        temp = bcs[aBC].p;
                    } else {
                        temp = bcs[aBC].p + bcs[bBC].p;
                    }
                    if (max < temp) max = temp;
                }
            }
        }
        return max;
    }
}
