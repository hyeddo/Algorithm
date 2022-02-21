package com.ssafy.algo.algo0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ16935_배열돌리기3 {

	private static int N = 0, M = 0, R = 0;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "6 8 6\r\n" + "3 2 6 3 1 2 9 7\r\n" + "9 7 8 2 1 4 5 3\r\n" + "5 9 2 1 9 6 1 8\r\n"
				+ "2 1 3 8 6 3 9 2\r\n" + "1 3 2 8 7 9 2 1\r\n" + "4 5 1 9 8 2 1 3\r\n" + "1 2 3 4 5 6";
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N=Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		String[] s = in.readLine().split(" ");
//		N = Integer.parseInt(s[0]);
//		M = Integer.parseInt(s[1]);

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] arr = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}

		String[] s2 = in.readLine().split(" ");
		int[] arr = new int[s2.length];
		for (int i = 0; i < s2.length; i++) {
			arr[i] = Integer.parseInt(s2[i]);
		}

		compute(arr);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void compute(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 1:
				for (int j = 0; j < N / 2; j++) {
					int[] temp = map[j];
					map[j] = map[N - j - 1];
					map[N - j - 1] = temp;
				}
				break;
			case 2:
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M / 2; k++) {
						int temp = map[j][k];
						map[j][k] = map[j][M - k - 1];
						map[j][M - k - 1] = temp;
					}
				}
				break;
			case 3:
				int[][] temp = new int[M][N];
				for (int j = 0; j < M; j++) {
					for (int k = 0; k < N; k++) {
						temp[j][k] = map[N - k - 1][j];
					}
				}
				map = temp;
				int t = N;
				N = M;
				M = t;
				break;
			case 4:
				int[][] temp2 = new int[M][N];
				for (int j = 0; j < M; j++) {
					for (int k = 0; k < N; k++) {
						temp2[j][k] = map[k][M - j - 1];
					}
				}
				map = temp2;
				int t2 = N;
				N = M;
				M = t2;
				break;
			case 5:
				int[][] temp3 = new int[N / 2][M / 2];
				for (int j = 0; j < N / 2; j++) {
					for (int k = 0; k < M / 2; k++) {
						temp3[j][k] = map[j][k];
						map[j][k] = map[j + N / 2][k];
						map[j + N / 2][k] = map[j + N / 2][k + M / 2];
						map[j + N / 2][k + M / 2] = map[j][k + M / 2];
						map[j][k + M / 2] = temp3[j][k];
					}
				}
				break;
			case 6:
				int[][] temp4 = new int[N / 2][M / 2];
				for (int j = 0; j < N / 2; j++) {
					for (int k = 0; k < M / 2; k++) {
						temp4[j][k] = map[j][k];
						map[j][k] = map[j][k + M / 2];
						map[j][k + M / 2] = map[j + N / 2][k + M / 2];
						map[j + N / 2][k + M / 2] = map[j + N / 2][k];
						map[j + N / 2][k] = temp4[j][k];
					}
				}
				break;
			}
		}
	}
}
