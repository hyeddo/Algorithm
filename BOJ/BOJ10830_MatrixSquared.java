package com.ssafy.study14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ10830_MatrixSquared {

    static int N;
    static long B;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "3 3\n" +
                "1 2 3\n" +
                "4 5 6\n" +
                "7 8 9";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }

        int[][] result = pow(matrix, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] pow(int[][] matrix, long b) {
        if(b == 1){
            return matrix;
        }
        
        int[][] temp = pow(matrix, b/2);
        
        temp = multiply(temp, temp);

        if(b % 2 == 1){
            temp = multiply(temp, matrix);
        }
        return temp;
    }

    private static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += m1[i][k] * m2[k][j];
                    temp[i][j] %= 1000;
                }
            }
        }
        return temp;
    }
}
