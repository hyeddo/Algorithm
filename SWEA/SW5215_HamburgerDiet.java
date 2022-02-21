package com.ssafy.algo.algo0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SW5215_HamburgerDiet {

	static String str = "1\r\n" + 
			"5 1000\r\n" + 
			"100 200\r\n" + 
			"300 500\r\n" + 
			"250 300\r\n" + 
			"500 1000\r\n" + 
			"400 400";
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, L, taste[], calories[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new StringReader(str));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			String[] arr = in.readLine().split(" ");
			N = Integer.parseInt(arr[0]);
			L = Integer.parseInt(arr[1]);
			taste = new int[N];
			calories = new int[N];
			for (int i = 0; i < N; i++) {
				arr = in.readLine().split(" ");
				taste[i] = Integer.parseInt(arr[0]);
				calories[i] = Integer.parseInt(arr[1]);
			}

			int result = calculate(0, 0, 0);
			
			sb.append("#").append(tc+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int calculate(int currTaste, int currCal, int currIdx) {
		if (currCal > L) {
			return 0;
		} else if(currIdx == N) {
			return currTaste;
		} else {
			return Math.max(calculate(currTaste, currCal, currIdx + 1), calculate(currTaste + taste[currIdx], currCal + calories[currIdx], currIdx + 1));
		}
	}

}
