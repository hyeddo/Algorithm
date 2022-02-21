package com.ssafy.algo.algo0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1289_WonjaeMemoryRecovery {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		
		for(int i = 0; i< tc;i++) {
			sb.append("#").append(i+1).append(" ").append(recovery(in.readLine())).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int recovery(String str) {
		int cnt = 0;
		char curr = '0'; 
		char[] chars = str.toCharArray();
		for(int i = 0; i< chars.length; i++) {
			if(curr != chars[i]) {
				cnt++;
				curr = chars[i];
			}
		}
		return cnt;
	}
}
