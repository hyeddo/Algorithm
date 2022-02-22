package com.ssafy.study03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2477_KMelonField {

    static int K, maxX, maxY, ans;
    static int[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "7\n" +
                "4 50\n" +
                "2 160\n" +
                "3 30\n" +
                "1 60\n" +
                "3 20\n" +
                "1 100";
        in = new BufferedReader(new StringReader(str));

        K = Integer.parseInt(in.readLine());
        field = new int[6][2];
        maxX = 0;
        maxY = 0;
        ans = 0;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            field[i][0] = Integer.parseInt(st.nextToken());
            field[i][1] = Integer.parseInt(st.nextToken());
            if ((field[i][0] == 1 || field[i][0] == 2) && field[i][1] > maxX)
                maxX = field[i][1];
            else if ((field[i][0] == 3 || field[i][0] == 4) && field[i][1] > maxY)
                maxY = field[i][1];
        }

        compute();
        System.out.println(ans);
    }

    private static void compute() {
        int big = maxX * maxY;
        int small = 0;
        int smallX = 0, smallY = 0;
        for (int i = 0; i < 6; i++) {
            if(field[i][0] == 1 || field[i][0] == 2){
                if(field[(i+5)%6][1] + field[(i+1)%6][1] == maxY){
                    smallX = field[i][1];
                }
            } else{
                if(field[(i+5)%6][1] + field[(i+1)%6][1] == maxX){
                    smallY = field[i][1];
                }
            }
        }
        small = smallX * smallY;
        ans = (big - small) * K;
    }
}
