package com.ssafy.study13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ12904_AandB {

    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "AB\n" +
                "ABB";
        in = new BufferedReader(new StringReader(str));

        S = in.readLine();
        T = in.readLine();

        while(S.length()<T.length()){
            if(T.charAt(T.length() - 1) == 'A'){
                T = T.substring(0, T.length() - 1);
            } else if(T.charAt(T.length() - 1) == 'B'){
                T = T.substring(0, T.length() - 1);
                T = new StringBuilder(T).reverse().toString();
            }
        }

        if(S.equals(T))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
