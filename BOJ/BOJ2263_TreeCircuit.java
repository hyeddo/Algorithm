package com.ssafy.study14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ2263_TreeCircuit {

    static int n;
    static int[] inorder, postorder, preorder;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "3\n" +
                "1 2 3\n" +
                "1 3 2";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(in.readLine());
        inorder = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        postorder = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        preorder = new int[n];
        idx = 0;
        compute(0, n - 1, 0, n - 1);

        for (int i = 0; i < n; i++) {
            sb.append(preorder[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void compute(int i1, int i2, int p1, int p2) {
        if (i1 <= i2 && p1 <= p2) {
            preorder[idx++] = postorder[p2]; // 포스트 오더의 가장 오른쪽은 루트 노드
            int pos = i1;
            for (int i = i1; i <= i2; i++) { // 인오더에서 루트 노드의 위치를 찾음
                if (inorder[i] == postorder[p2]) {
                    pos = i;
                    break;
                }
            }
            //왼쪽 자식 트리
            compute(i1, pos - 1, p1, p1 + pos - i1 - 1);
            //오른쪽 자식 트리
            compute(pos + 1, i2, p1 + pos - i1, p2 - 1);
        }
    }
}
