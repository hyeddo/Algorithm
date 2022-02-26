package com.ssafy.study04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ1244_SwitchOnOff {

    static int switchNum, studentNum;
    static int[] state;
    static Student[] students;

    static class Student {
        int gender, cnt;

        public Student(int gender, int cnt) {
            this.gender = gender;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "8\n" +
                "0 1 0 1 0 0 0 1\n" +
                "2\n" +
                "1 3\n" +
                "2 3";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        switchNum = Integer.parseInt(in.readLine());
        state = new int[switchNum];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < switchNum; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }
        studentNum = Integer.parseInt(in.readLine());
        students = new Student[studentNum];
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(in.readLine());
            students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            manipulate(students[i]);
        }
        for (int i = 0; i < switchNum; i++) {
            if(i != 0 && i % 20 == 0)
                sb.append("\n");
            sb.append(state[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void manipulate(Student student) {
        int num = student.cnt;
        if (student.gender == 1) {
            for (int i = 0; i < switchNum; i++) {
                if ((i + 1) % num == 0) {
                    state[i] = 1 - state[i];
                }
            }
        } else {
            for (int i = 0; i < switchNum / 2; i++) {
                if (i == 0) state[num - 1] = 1 - state[num - 1];
                else if (num - 1 - i >= 0 && num - 1 + i < switchNum && state[num - 1 - i] == state[num - 1 + i]) {
                    state[num - 1 - i] = 1 - state[num - 1 - i];
                    state[num - 1 + i] = 1 - state[num - 1 + i];
                } else{
                    break;
                }
            }
        }
    }
}
