package com.ssafy.study17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110_ModemInstall {

    static int C, N, low, high;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "5 3\n" +
                "1\n" +
                "2\n" +
                "8\n" +
                "4\n" +
                "9";
        in = new BufferedReader(new StringReader(str));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(map);

        low = 1;
        high = map[N - 1] - map[0] + 1;
        compute();
        System.out.println(low - 1);
    }

    private static void compute() {
        while (low < high) {
            int mid = (low + high) / 2;

            if (possible(mid) < C) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
    }

    // 설치 가능한 공유기 개수 계산
    private static int possible(int dist) {
        int count = 1;
        int last = map[0];

        for (int i = 1; i < N; i++) {
            int pos = map[i];
            if (pos - last >= dist) {
                count++;
                last = pos;
            }
        }
        return count;
    }
}
