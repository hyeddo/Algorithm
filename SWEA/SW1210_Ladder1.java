package com.ssafy.algo.algo0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SW1210_Ladder1 {

    private static int d[][] = {{0, 1}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "1\n" +
                "1 0 0 0 1 0 1 0 0 1\n" +
                "1 0 0 0 1 0 1 1 1 1\n" +
                "1 0 0 0 1 0 1 0 0 1\n" +
                "1 0 0 0 1 1 1 0 0 1\n" +
                "1 0 0 0 1 0 1 0 0 1\n" +
                "1 1 1 1 1 0 1 1 1 1\n" +
                "1 0 0 0 1 0 1 0 0 1\n" +
                "1 1 1 1 1 0 1 0 0 1\n" +
                "1 0 0 0 1 1 1 0 0 1\n" +
                "1 0 0 0 1 0 1 0 0 2";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            in.readLine();

            int[][] map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                String[] line = in.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            int row=99;
            int col = 0;
            for (int i = 99; i >= 0; i--) {
                if (map[99][i] == 2) {
                    col = i;
                    break;
                }
            }

            int answer = 0;
            boolean isFound = false;
            while(!isFound){
                for(int i=0;i<3;i++){
                    int nextR = row +d[i][0];
                    int nextC = col + d[i][1];
                    if(nextR >=0 && nextR <= 99 && nextC >= 0 && nextC<=99 && map[nextR][nextC] == 1){
                        if(nextR == 0) {
                            answer = nextC;
                            isFound = true;
                            break;
                        }
                        map[row][col] = 0;
                        row = nextR;
                        col = nextC;
                    }

                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");

        }
        System.out.println(sb.toString());
    }
}
