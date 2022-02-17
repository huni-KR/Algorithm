package SW4012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW4012 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] arr;
    static boolean[] visit;
    static List<Integer> list1, list2;
    static int N, min;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            visit = new boolean[N];
            fun(0, 0);

            bw.write("#" + Integer.toString(t) + " " + Integer.toString(min) + "\n");
        }
        bw.flush();
    }

    private static void fun(int pos, int count) {
        if (count == N / 2) {
            calc();
            return;
        }

        for (int i = pos; i < arr.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            fun(i, count + 1);
            visit[i] = false;
        }
    }

    private static void calc() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }

        int a = 0, b = 0;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i; j < list1.size(); j++) {
                a += arr[list1.get(i)][list1.get(j)] + arr[list1.get(j)][list1.get(i)];
                b += arr[list2.get(i)][list2.get(j)] + arr[list2.get(j)][list2.get(i)];
            }
        }
        min = Math.min(min, Math.abs(a - b));
    }
}