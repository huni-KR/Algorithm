package BOJ_1929;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1929 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int m, n;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        prime = new boolean[n + 1];
        fun();

        for (int i = m; i <= n; i++) {
            if (!prime[i]) {
                bw.write(Integer.toString(i));
                bw.write("\n");
            }
        }
        bw.flush();
    }

    private static void fun() {
        prime[1] = true;
        mark(2);
        boolean flag = true;
        for (int i = 3; i * i <= n; i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                mark(i);
            } else {
                flag = true;
            }
        }
    }

    private static void mark(int index) {
        for (int i = index * 2; i <= n; i += index) {
            prime[i] = true;
        }
    }
}