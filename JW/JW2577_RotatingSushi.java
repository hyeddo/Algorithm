package com.ssafy.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JW2577_RotatingSushi {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] chobab = new int[n];
        for (int i = 0; i < n; i++) {
            chobab[i] = Integer.parseInt(in.readLine());
        }
        int[] v = new int[d + 1];
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (v[chobab[i]] == 0) {
                ans++;
            }
            v[chobab[i]]++;
        }
        int cnt = ans;
        for (int i = 1; i < n; i++) {
            if (cnt >= ans) {
                if (v[c] == 0) {
                    ans = cnt + 1;
                } else {
                    ans = cnt;
                }
            }
            v[chobab[i - 1]]--;
            if (v[chobab[i - 1]] == 0) {
                cnt--;
            }
            if (v[chobab[(i + k - 1) % n]] == 0) cnt++;
            v[chobab[(i + k - 1) % n]]++;
        }
        System.out.println(ans);
    }
}