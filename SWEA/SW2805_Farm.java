package com.ssafy.algo.algo0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW2805_Farm {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int total = 0;

			for (int i = 0; i < N; i++) {
				for (int j = Math.abs(N / 2 - i); j < N - Math.abs(N / 2 - i); j++) {
					total += map[i][j];
				}
			}

			sb.append("#").append(tc + 1).append(" ").append(total).append("\n");
		}
		System.out.println(sb.toString());
	}

}
