package BOJ_3040;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_3040 {
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean[] visit;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 9;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        visit = new boolean[n];
        fun(arr, 0);

    }

    private static void fun(int[] arr, int count) {
        if (flag) {
            return;
        }

        if (count == 7) {
            if (sum(arr, visit) == 100) {
                flag = true;
                for (int i = 0; i < visit.length; i++) {
                    if (visit[i]) {
                        System.out.println(arr[i]);
                    }
                }
            }
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            fun(arr, count + 1);
            visit[i] = false;
        }
    }

    private static int sum(int[] arr, boolean[] visit) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) {
                sum += arr[i];
            }
        }
        return sum;
    }
}