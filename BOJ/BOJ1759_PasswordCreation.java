package com.ssafy.algo.algo0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1759_PasswordCreation {

    static int L, C;
    static List<Character> words;
    static String pwd;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "4 6\n" +
                "a t c i s w";
        in = new BufferedReader(new StringReader(str));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        words = new ArrayList<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < C; i++) {
            words.add(st.nextToken().charAt(0));
        }

        Collections.sort(words);

        password(0, "");

        System.out.println(sb);
    }

    private static void password(int curr, String pwd) {
        if (pwd.length() == L) {
            int vowelCnt = 0, consoCnt = 0;
            for (int i = 0; i < L; i++) {
                char word = pwd.charAt(i);
                if (word == 'a' || word == 'e' || word == 'i' || word == 'o' || word == 'u') {
                    vowelCnt++;
                } else {
                    consoCnt++;
                }
            }
            if (vowelCnt >= 1 && consoCnt >= 2) {
                sb.append(pwd).append("\n");
            }
            return;
        }
        if (curr == C) return;
        char word = words.get(curr);
        password(curr + 1, pwd + word);
        password(curr + 1, pwd);
    }
}
