package BOJ_1509;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1509 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static char[] arr;
    static int N;
    static int min;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = br.readLine().toCharArray();
        N = arr.length;

        min = Integer.MAX_VALUE;
        fun(0, arr.length, 0);

        System.out.println(min);
    }

    private static void fun(int s, int e, int count) {
        if (s == e) {
            return;
        }
    }
}