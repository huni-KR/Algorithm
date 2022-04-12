package SW5607;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SW5607 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, N, R, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Long.toString(fun(N, R, 1234567891)));
            bw.write("\n");
        }
        bw.flush();
    }

    private static Long fun(int n, int r, int p) {
        if (r == 0) {
            return 1L;
        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1] * i % p;
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