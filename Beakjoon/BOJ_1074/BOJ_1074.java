package BOJ_1074;

import java.io.*;
import java.util.*;

public class BOJ_1074 {

    static int count;
    static int r;
    static int c;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        br.close();

        int ans = func(N, r, c);
        System.out.println(ans);
    }

    static int func(int n, int r, int c) {
        if (n == 0)
            return 0;
        int half = (int) Math.pow(2, n - 1);

        if (r < half && c < half) {
            return func(n - 1, r, c);
        }
        if (r < half && c >= half) {
            return half * half + func(n - 1, r, c - half);
        }
        if (r >= half && c < half) {
            return 2 * half * half + func(n - 1, r - half, c);
        }
        return 3 * half * half + func(n - 1, r - half, c - half);
    }
}
