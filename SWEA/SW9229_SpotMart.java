package com.ssafy.algo.algo0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SW9229_SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "4\r\n" + 
				"3 45\r\n" + 
				"20 20 20\r\n" + 
				"6 10\r\n" + 
				"1 2 5 8 9 11\r\n" + 
				"4 100\r\n" + 
				"80 80 60 60\r\n" + 
				"4 20\r\n" + 
				"10 5 10 16";
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < TC; tc++) {
			String[] s = in.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			s = in.readLine().split(" ");
			int[] weight = new int[N];
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(s[i]);
			}

			sb.append("#").append(tc+1).append(" ").append(pick(weight, M, 0, 0, -1)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int pick(int[] weight, int M, int cnt, int currSum, int currIdx) {
		if (cnt >= 2) {
			if (currSum <= M)
				return currSum;
			else {
				return -1;
			}
		} else if(currIdx>=weight.length - 1){
			return -1;
		}else{
			return Math.max(pick(weight, M, cnt + 1, currSum + weight[currIdx + 1], currIdx + 1),
					pick(weight, M, cnt, currSum, currIdx + 1));
		}

	}

}
