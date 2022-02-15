package SW6808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW6808 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] arr;
    static int[] result;
    static boolean[] cards;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = 9;
            arr = new int[2][n];
            result = new int[2];
            cards = new boolean[19];
            for (int i = 0; i < arr[0].length; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
                cards[arr[0][i]] = true;
            }

            fun(9, 0);

            System.out.printf("#%d %d %d\n", t, result[1], result[0]);
        }
    }

    private static void fun(int total, int count) {
        if (count == total) {
            if (isWin()) {
                result[0]++;
            } else {
                result[1]++;
            }
            return;
        }

        for (int i = 1; i < cards.length; i++) {
            if (cards[i]) {
                continue;
            }

            cards[i] = true;
            arr[1][count] = i;
            fun(total, count + 1);
            cards[i] = false;
            arr[1][count] = -1;
        }
    }

    private static boolean isWin() {
        int[] score = new int[2];
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] < arr[1][i]) {
                score[0] += arr[0][i] + arr[1][i];
            } else {
                score[1] += arr[0][i] + arr[1][i];
            }
        }
        return score[0] > score[1];
    }
}