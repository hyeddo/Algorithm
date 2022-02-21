package com.ssafy.algo.algo0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1954_SnailNumber {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			sb.append("#").append(i + 1).append("\n");
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			snail(N, map);
			for (int[] arr : map) {
				for (int num : arr) {
					sb.append(num).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void snail(int n, int[][] map) {
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[] curr = { 0, 0 };
		int d = 0;

		for (int i = 1; i <= n * n; i++) {
			map[curr[0]][curr[1]] = i;
			if (curr[0] + dir[d % 4][0] == n || curr[1] + dir[d % 4][1] == n || curr[0] + dir[d % 4][0] == -1
					|| curr[1] + dir[d % 4][1] == -1 || map[curr[0] + dir[d % 4][0]][curr[1] + dir[d % 4][1]] != 0)
				d++;
			curr[0] += dir[d % 4][0];
			curr[1] += dir[d % 4][1];
		}
	}
}
