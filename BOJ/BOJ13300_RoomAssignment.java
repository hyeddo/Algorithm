package com.ssafy.study04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13300_RoomAssignment {

    static int N, K;
    static Student[] students;

    static class Student implements Comparable<Student>{
        int S, Y;

        public Student(int s, int y) {
            S = s;
            Y = y;
        }

        @Override
        public int compareTo(Student o) {
            if(this.S == o.S)
                return this.Y - o.Y;
            return this.S - o.S;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "3 3\n" +
                "0 3\n" +
                "1 5\n" +
                "0 6";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        students = new Student[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students);

        int ans = 1;
        int temp = 1;
        for (int i = 1; i < N; i++) {
            if(students[i-1].S == students[i].S && students[i-1].Y == students[i].Y && temp < K){
                temp++;
                continue;
            }
            ans++;
            temp = 1;
        }
        System.out.println(ans);
    }
}
