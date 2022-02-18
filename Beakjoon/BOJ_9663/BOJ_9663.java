package BOJ_9663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9663 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        sum = 0;
        arr = new int[N + 1];
        fun(1);
        System.out.println(sum);
    }

    private static void fun(int row) {
        if (!able(row - 1)) {
            return;
        }

        if (row == N + 1) {
            sum++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[row] = i;
            fun(row + 1);
        }
    }

    private static boolean able(int row) {
        for (int i = 1; i < row; i++) {
            if (arr[row] == arr[i] || Math.abs(arr[i] - arr[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
