package com.ssafy.algo.algo0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JW1828_Refrigerator {

    public static class Temparature implements Comparable<Temparature> {
        int lowest, highest;

        public Temparature(int lowest, int highest) {
            this.lowest = lowest;
            this.highest = highest;
        }

        @Override
        public int compareTo(Temparature tp) {
            if (this.lowest != tp.lowest) {
                return this.lowest - tp.lowest;
            } else {
                return this.highest - tp.highest;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "71\n" +
                "1 7\n" +
                "-45 27\n" +
                "-70 46\n" +
                "170 266\n" +
                "130 459\n" +
                "19 450\n" +
                "1266 3455\n" +
                "1569 3487\n" +
                "4283 8422\n" +
                "0 0\n" +
                "1 6\n" +
                "-34 25\n" +
                "-25 23\n" +
                "28 113\n" +
                "195 461\n" +
                "651 683\n" +
                "554 1256\n" +
                "2386 3166\n" +
                "902 6891\n" +
                "0 0\n" +
                "1 3\n" +
                "-35 22\n" +
                "-57 3\n" +
                "31 380\n" +
                "52 443\n" +
                "329 629\n" +
                "633 3555\n" +
                "1318 6556\n" +
                "2824 9992\n" +
                "0 0\n" +
                "4 7\n" +
                "-47 41\n" +
                "46 80\n" +
                "290 391\n" +
                "91 612\n" +
                "181 619\n" +
                "1420 2064\n" +
                "2076 7747\n" +
                "842 9402\n" +
                "0 0\n" +
                "7 8\n" +
                "21 22\n" +
                "62 99\n" +
                "21 257\n" +
                "70 711\n" +
                "417 811\n" +
                "982 3010\n" +
                "5364 7186\n" +
                "6029 7532\n" +
                "0 0\n" +
                "8 8\n" +
                "30 39\n" +
                "23 37\n" +
                "259 281\n" +
                "-116 106\n" +
                "592 761\n" +
                "2102 3478\n" +
                "3045 5549\n" +
                "3144 7916\n" +
                "0 0\n" +
                "1 3\n" +
                "36 43\n" +
                "-40 37\n" +
                "12 206\n" +
                "325 712\n" +
                "347 573\n" +
                "96 1229\n" +
                "4189 5845\n" +
                "8675 9374\n" +
                "0 0\n" +
                "0 1";
        in = new BufferedReader(new StringReader(str));

        int N = Integer.parseInt(in.readLine());
        Temparature[] temparatures = new Temparature[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            temparatures[i] = new Temparature(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        List<Temparature> result = new ArrayList<>();
        result = getTemparature(temparatures);

        System.out.println(result.size());
    }

    private static List<Temparature> getTemparature(Temparature[] temparatures) {
        ArrayList<Temparature> result = new ArrayList<>();
        Arrays.sort(temparatures);
        result.add(temparatures[0]);

        int left = temparatures[0].lowest, right = temparatures[0].highest;
        for (int i = 1, size = temparatures.length; i < size; i++) {
            if (right < temparatures[i].lowest) {
                result.add(temparatures[i]);
                left = temparatures[i].lowest;
                right = temparatures[i].highest;
            } else {
                if (left < temparatures[i].lowest)
                    left = temparatures[i].lowest;
                if( right > temparatures[i].highest)
                    right = temparatures[i].highest;
            }

        }
        return result;
    }
}
