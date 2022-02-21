package com.ssafy.algo.algo0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class SW1224_Calculator3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "113\n" +
                "(9+(5*2+1)+(3*3*7*6*9*1*7+1+8*6+6*1*1*5*2)*4*7+4*3*8*2*6+(7*8*4*5)+3+7+(2+6+5+1+7+6+7*3*(6+2)+6+6)*2+4+2*2+4*9*3)\n" +
                "85\n" +
                "(4+8+4*(8*5*(7*(6*8)+3+(6+(3+7+1*7*5*4)*3)*2*3+5)+6+7*7)*4+2+9*4+7+2*3*(7*6*1*8)+9+9)\n" +
                "97\n" +
                "(9*5+7+8+6+3+9*2+1+7+4+3+9*3*1+4*(4+4*3*1+9*3+(9*5)*1*7*8+2+8+8*7+9*4*9)+(1+1*8+8*9*7+1*4*5*2*5))\n" +
                "89\n" +
                "((3*1*4+6*3+8+4+5+4+2*1+5+3*4)*1+1+(3*2*2+9+5*4*6*9+9+4+1*8+9)*4*8+9+3*7+9*6*9*5+8+3*8+1)\n" +
                "125\n" +
                "(2+(6*5+6+5+3*9+6+2+8*2+2)+6+2*2+2*5*1*2+1*8+1*(4+7*5+8+9+7+3*8*5)+(2+9+5*4*4+1+3*9*6*4*5+(5*(3+4)*9+8+7+9*2)+7+7+2)+8+2+7+5)\n" +
                "113\n" +
                "(8+8*6+3*9*8*7*6*3+5*(7*6*6+3*5+2*4*9*3+5+2+1*4)*1*7+6*8+9+3+2+8*3+8*(2+6*9+2*2*7+8*1*2+9*3+1+5)*(5*8+4*1*2*4*2))\n" +
                "115\n" +
                "(7+9*2+6+5*7+1*7*(9+8+6)*1*2+7+5*9*6*3+4*8*9*6*1*3+7*1+2+5+1*4*9+6*4+7*1*2*4*2+3+((3*4+9+7*1+7+5+3*7*1*7+8*3*8)+7))\n" +
                "99\n" +
                "(9*4+(1+5*7*8+9+1+2)+5+(6*(7+4*5*2+4+8*4+7)+9)*1*3*1+1*2*8+3+(2+9*(1*5*9+7*1+1+7+3*2))+1+3*7*8+9*6)\n" +
                "75\n" +
                "(2*2+((7+8*8*6+(6*6)*7+7*1)*5)*7+3+1*5+1*8*4+(9+6+(7*5+3+1*8*8*9+4+7+9)*3))\n" +
                "117\n" +
                "(8+6*9+2*3+4+2+(6+9+3+7*5*1+2+2+2)*9+4+6*1+6*4+7+7*2+5+2*6*(8*9*8*6+4*2)*5+5*8*3+(6+1+3+3*8*1*2*1+5+6)+1+5+4*7*1*3+1)\n";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(in.readLine());
            String s = in.readLine();
            String post = "";
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
                    post += s.charAt(i);
                } else {
                    switch (s.charAt(i)) {
                        case '+':
                            do {
                                if (stack.isEmpty())
                                    break;
                                if(stack.peek() == '(')
                                    break;
                                post += stack.pop();
                            } while (!stack.isEmpty());
                            stack.push(s.charAt(i));
                            break;
                        case '*':
                        case '(':
                            stack.push(s.charAt(i));
                            break;
                        case ')':
                            while(stack.peek() != '('){
                                post += stack.pop();
                            }
                            stack.pop();
                            break;
                    }
                }
            }
            while (!stack.isEmpty()) {
                post += stack.pop();
            }

            Stack<Integer> result = new Stack<>();
            for (int i = 0; i < post.length(); i++) {
                if (post.charAt(i) >= '1' && post.charAt(i) <= '9') {
                    result.push(post.charAt(i) - '0');
                } else {
                    int num1 = result.pop();
                    int num2 = result.pop();
                    if (post.charAt(i) == '*') {
                        result.push(num1 * num2);
                    } else if (post.charAt(i) == '+') {
                        result.push(num1 + num2);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(result.pop()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
