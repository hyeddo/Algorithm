package com.ssafy.study17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2022_Ladder {

    static double x, y, c, low, high;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "30 40 10";
        in = new BufferedReader(new StringReader(str));

        StringTokenizer st = new StringTokenizer(in.readLine());
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());

        low = 0;
        high = Math.min(x, y);
        compute();
        System.out.printf("%.3f\n", low - 0.001);
    }

    private static void compute() {
        while (low < high) {
            double mid = (low + high) / 2.0;

            if (getHeight(mid) < c) {
                high = mid - 0.001;
            } else {
                low = mid + 0.001;
            }
        }
    }

    private static double getHeight(double dist) {
        double height = 0;
        double hx = Math.sqrt(x * x - dist * dist);
        double hy = Math.sqrt(y * y - dist * dist);
        return (hx * hy) / (hx + hy);
    }
}
