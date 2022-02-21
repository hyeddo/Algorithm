package com.ssafy.algo.algo0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < 10; tc++) {
			int dump = Integer.parseInt(in.readLine());
			int[] box = new int[100];
			String numbers = in.readLine();
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(numbers.split(" ")[i]);
			}

			int diff = 0;

			for (int i = 0; i <= dump; i++) {
				int min = 101;
				int max = 0;
				int minIdx = 0;
				int maxIdx = 0;

				for (int j = 0; j < 100; j++) {
					if (min > box[j]) {
						min = box[j];
						minIdx = j;
					}
					if (max < box[j]) {
						max = box[j];
						maxIdx = j;
					}
				}				
				diff = max - min;
				
				if (diff < 2)
					break;
				box[minIdx]++;
				box[maxIdx]--;
			}
			sb.append("#").append(tc + 1).append(" ").append(diff).append("\n");
		}
		System.out.println(sb.toString());
	}
}
