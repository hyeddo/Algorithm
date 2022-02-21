package com.ssafy.algo.algo0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SW1225_PasswordCreator {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "1\r\n" + "9550 9556 9550 9553 9558 9551 9551 9551\r\n" + "2\r\n"
				+ "2419 2418 2423 2415 2422 2419 2420 2415";
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String t = in.readLine();
			if (t == null)
				break;
			int tc = Integer.parseInt(t);
			String[] s = in.readLine().split(" ");
			Queue<Integer> nums = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				nums.add(Integer.parseInt(s[i]));
			}

			while (true) {
				boolean result = cycle(nums);
				if (result)
					break;
			}

			sb.append("#").append(tc);
			for (int i = 0; i < 8; i++) {
				sb.append(" ").append(nums.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean cycle(Queue<Integer> nums) {
		boolean result = false;
		for (int i = 1; i <= 5; i++) {
			int num = nums.poll() - i;
			if (num <= 0) {
				nums.add(0);
				result = true;
				break;
			}
			nums.add(num);
		}
		return result;
	}
}
