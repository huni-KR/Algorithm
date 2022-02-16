package BOJ_1074;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1074_2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, R, C, size, count;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N);
        System.out.println(fun(0, 0, size) - 1);
    }

    private static int fun(int y, int x, int len) {
        if (flag) {
            return 0;
        }
        if (len == 1) {
            if (y == R && x == C) {
                flag = true;
            }
            return 1;
        }

        if (y <= R && R < y + len / 2 && x <= C && C < x + len / 2) {
            return fun(y, x, len / 2);
        } else if (y <= R && R < y + len / 2 && x + len / 2 <= C && C < x + len) {
            return (len / 2 * len / 2) + fun(y, x + len / 2, len / 2);
        } else if (y + len / 2 <= R && R < y + len && x <= C && C < x + len / 2) {
            return 2 * (len / 2 * len / 2) + fun(y + len / 2, x, len / 2);
        } else {
            return 3 * (len / 2 * len / 2) + fun(y + len / 2, x + len / 2, len / 2);
        }
    }
}
