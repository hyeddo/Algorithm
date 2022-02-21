package com.ssafy.algo.algo0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ16926_배열돌리기 {

	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "4 4 2\r\n" + "1 2 3 4\r\n" + "5 6 7 8\r\n" + "9 10 11 12\r\n" + "13 14 15 16";
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		String[] s = in.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] arr = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}

		rotate(map, N, M, R);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void rotate(int[][] map, int N, int M, int R) {
		int groupNum = Math.min(N, M) / 2;
		for (int r = 0; r < R; r++) {
			for (int i = 0; i < groupNum; i++) {
				int currX = i, currY = i;
				int start = map[i][i];
				int j = 0;
				while (j < 4) {
					int nextX = currX + dir[j][0];
					int nextY = currY + dir[j][1];
					if (nextX >= i && nextY >= i && nextX < N - i && nextY < M - i) {
						map[currX][currY] = map[nextX][nextY];
						currX = nextX;
						currY = nextY;
					} else
						j++;
				}
				map[i + 1][i] = start;
			}
		}
	}
}
