package BOJ_11401;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11401 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, R;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        System.out.println(Long.toString(fun(N, R, 1000000007)));
    }

    private static Long fun(int n, int r, int p) {
        if (r == 0) {
            return 1L;
        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i % p;
        }

        return (factorial[n] * power(factorial[r], p - 2, p) % p * power(factorial[n - r], p - 2, p) % p) % p;
    }

    private static long power(long x, int y, int p) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}