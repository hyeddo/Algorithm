package com.ssafy.algo.algo0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "5\r\n" + "6 9 5 7 4";
		in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s);
		Stack<Integer> heightStack = new Stack<>();
		Stack<Integer> idxStack = new Stack<>();
		int[] answers = new int[N];
		for (int i = 0; i < N; i++) {
			int curr = Integer.parseInt(st.nextToken());
			while (!heightStack.empty()) {
				if (heightStack.peek() >= curr) {
					answers[i] = idxStack.peek();
					break;
				} else {
					heightStack.pop();
					idxStack.pop();
				}
			}
			heightStack.push(curr);
			idxStack.push(i + 1);
			sb.append(answers[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}
