package com.ssafy.study03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2491_Sequence {
    static int N, ans;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "9\n" +
                "4 1 3 3 2 2 9 2 3";
        in = new BufferedReader(new StringReader(str));

        N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        numbers = new int[N];
        for(int i=0;i<N;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        if(N <= 1) ans = N;
        else {
            traverse();
        }

        System.out.println(ans);
    }

    private static void traverse() {
        int compare = Integer.compare(numbers[0], numbers[1]);
        int length = 2;
        int poss = 0;
        for (int i = 1; i < N - 1; i++) {
            int temp = Integer.compare(numbers[i], numbers[i+1]);
            if(temp == 0){
                poss++;
                length++;
            }
            else if(temp == compare){
                poss = 0;
                length++;
            } else{
                length = 2 + poss;
                poss = 0;
                compare = temp;
            }
            if(ans < length) ans = length;
        }
    }
}
