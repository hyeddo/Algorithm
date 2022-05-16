package com.ssafy.study13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2212_Sensor {

    static int N, K, ans;
    static int[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "10\n" +
                "5\n" +
                "20 3 14 6 7 8 18 10 12 15";
        in = new BufferedReader(new StringReader(str));

        N = Integer.parseInt(in.readLine());
        K = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        pos = new int[N];
        for (int i = 0; i < N; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pos);
        Integer[] diff = new Integer[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = pos[i + 1] - pos[i];
        }
        Arrays.sort(diff, Collections.reverseOrder());
        ans = 0;
        for (int i = K-1; i < N-1; i++) {
            ans += diff[i];
        }
        System.out.println(ans);
    }
}
