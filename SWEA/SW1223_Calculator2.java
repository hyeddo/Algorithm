package com.ssafy.algo.algo0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class SW1223_Calculator2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "101\n" +
                "9+5*2+1+3*3*7*6*9*1*7+1+8*6+6*1*1*5*2*4*7+4*3*8*2*6+7*8*4*5+3+7+2+6+5+1+7+6+7*3*6+2+6+6*2+4+2*2+4*9*3\n" +
                "79\n" +
                "4+4*3*4*9+2+7*4*7+7*7*9*5*2+8*8+2*6*7*3*7*9*3*4+8+8*9+3+9+6+9+4*1+6*3+5+1+7+5*1\n" +
                "113\n" +
                "2+3+9*9+8+2*1+3*2*3*1+3*3+1+2+3*6*2*7*4+9+1+4+6+9*9*5+7+8+6+3+9*2+1+7+4+3+9*3*1+4*4+4*3*1+9*3+9*5*1*7*8+2+8+8*7+9\n" +
                "89\n" +
                "4*9+1+1*8+8*9*7+1*4*5*2*5+8*3*5+5+2*4+2+8+6*2*2+9+3*1*2+2*5+9*2*3*9+6+7*9+9*4+7+6+6*6+3+8\n" +
                "77\n" +
                "5+4+9+9*9*2+6*6*5+9+3*5+5*7*8*3*7*1*9*9+8+3+8*9*6+2*9*3+6*5+6*7*2+5+5*3+4*6+7\n" +
                "119\n" +
                "5+7+1+6+3+6*7+7+5*5*3*5*6*9+5*9*5*9+8+8+5*1*6*2+3+2+8+6+2+2*3*4+5*8*3*6*2*9+1*7*7*4*2+2*5+6+7+2*7*4+9*6*4*3*1*3*5+3*7+8\n" +
                "115\n" +
                "8*6+3*9*8*7*6*3+5*7*6*6+3*5+2*4*9*3+5+2+1*4*1*7+6*8+9+3+2+8*3+8*2+6*9+2*2*7+8*1*2+9*3+1+5*5*8+4*1*2*4*2*6*3*8*8+4+1\n" +
                "91\n" +
                "5*8*4+5*7+9*2+6+5*7+1*7*9+8+6*1*2+7+5*9*6*3+4*8*9*6*1*3+7*1+2+5+1*4*9+6*4+7*1*2*4*2+3+3*4+9\n" +
                "107\n" +
                "7*1+7+5+3*7*1*7+8*3*8+7+3*2*6*2+3+6*4+3+8+9*4+1+5*7*8+9+1+2+5+6*7+4*5*2+4+8*4+7+9*1*3*1+1*2*8+3+2+9*1*5*9+7\n" +
                "109\n" +
                "1+1+7+3*2+1+3*7*8+9*6+1+8*3*7+8*5*7*7+4*3*7*4+7+3+2*2+7+8*8*6+6*6*7+7*1*5*7+3+1*5+1*8*4+9+6+7*5+3+1*8*8*9+4+7\n";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(in.readLine());
            String s = in.readLine();
            Stack<Character> st = new Stack<>();
            String post = "";
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) >= '1' && s.charAt(j) <= '9') {
                    post += s.charAt(j);
                } else {
                    if (s.charAt(j) == '*') st.push(s.charAt(j));
                    else {
                        do {
                            if (st.isEmpty())
                                break;
                            post += st.pop();
                        } while (!st.isEmpty());
                        st.push(s.charAt(j));
                    }
                }
            }
            while (!st.isEmpty()) {
                post += st.pop();
            }
            Stack<Integer> result = new Stack<>();
            for (int j = 0; j < post.length(); j++) {
                if (post.charAt(j) >= '1' && post.charAt(j) <= '9') {
                    result.push(post.charAt(j) - '0');
                } else {
                    int num1 = result.pop();
                    int num2 = result.pop();
                    if (post.charAt(j) == '*') {
                        result.push(num1 * num2);
                    } else if (post.charAt(j) == '+') {
                        result.push(num1 + num2);
                    }
                }
            }
            sb.append("#").append(i + 1).append(" ").append(result.pop()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
