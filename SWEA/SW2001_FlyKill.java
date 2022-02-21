package com.ssafy.algo.algo0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW2001_FlyKill {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			String str = in.readLine();
			int N = Integer.parseInt(str.split(" ")[0]);
			int M = Integer.parseInt(str.split(" ")[1]);

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] nums = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(nums[j]);
				}
			}
			int max = 0;
			int sum = 0;

			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					for (int k = i; k < i + M; k++) {
						for (int l = j; l < j + M; l++) {
							sum += map[k][l];
						}
					}
					if (sum > max)
						max = sum;
					sum = 0;
				}
			}

			sb.append("#").append(tc + 1).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
