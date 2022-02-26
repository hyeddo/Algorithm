package com.ssafy.study04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2635_NumberConnect {

    static int first, ans;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "100";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        first = Integer.parseInt(in.readLine());

        ans = 0;
        connect();
        sb.append(ans).append("\n");      for (Integer i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void connect() {
        int target = 0;
        for (int i = first; i >= first / 2; i--) {
            makeNumbers(i);
        }
    }

    private static void makeNumbers(int second) {
        int prev = first;
        int curr = second;
        int cnt = 2;
        List<Integer> list = new ArrayList<>();
        list.add(prev);
        list.add(curr);
        while (curr >= 0) {
            int temp = prev;
            prev = curr;
            curr = temp - curr;
            if (curr >= 0) {
                list.add(curr);
                cnt++;
            } else
                break;
        }
        if (ans < cnt) {
            ans = cnt;
            result = list;
        }
    }
}
