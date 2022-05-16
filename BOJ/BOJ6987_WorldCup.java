package com.ssafy.study09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ6987_WorldCup {

    static int[][] matches;
    static boolean isEnd;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4\n" +
                "4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3\n" +
                "5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5\n" +
                "5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4";
        in = new BufferedReader(new StringReader(str));
        sb = new StringBuilder();

        matches = new int[15][2];
        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 6; j++) {
                matches[index][0] = i;
                matches[index][1] = j;
                index++;
            }
        }

        StringTokenizer st = null;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(in.readLine());
            int[][] worldCup = new int[6][3];
            boolean isPossible = true;

            for (int j = 0; j < 6; j++) {
                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());

                worldCup[j][0] = win;
                worldCup[j][1] = draw;
                worldCup[j][2] = lose;

                if(win + draw + lose != 5){
                    isPossible = false;
                    break;
                }
            }

            if(isPossible){
                backTrack(worldCup, 0, 15);
                if(isEnd){
                    sb.append(1);
                } else{
                    sb.append(0);
                }
            } else{
                sb.append(0);
            }
            sb.append(" ");
            isEnd = false;
        }
        System.out.println(sb);
    }

    private static void backTrack(int[][] worldCup, int cnt, int size) {
        if(isEnd) return;

        if(cnt == size){
            isEnd = true;
            return;
        }

        int first = matches[cnt][0];
        int second = matches[cnt][1];

        if(worldCup[first][0] > 0 && worldCup[second][2] > 0){
            worldCup[first][0]--;
            worldCup[second][2]--;
            backTrack(worldCup, cnt + 1, size);
            worldCup[first][0]++;
            worldCup[second][2]++;
        }

        if(worldCup[first][1] > 0 && worldCup[second][1] > 0) {
            worldCup[first][1]--;
            worldCup[second][1]--;
            backTrack(worldCup, cnt + 1, size);
            worldCup[first][1]++;
            worldCup[second][1]++;
        }

        if(worldCup[first][2] > 0 && worldCup[second][0] > 0) {
            worldCup[first][2]--;
            worldCup[second][0]--;
            backTrack(worldCup, cnt + 1, size);
            worldCup[first][2]++;
            worldCup[second][0]++;
        }
    }
}
