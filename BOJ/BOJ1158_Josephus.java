package com.ssafy.algo.algo0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1158_Josephus {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "7 3";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        String[] s = in.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                sb.append(queue.poll()).append(">");
                break;
            }
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        System.out.println(sb.toString());
    }
}
