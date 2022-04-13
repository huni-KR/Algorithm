package SW5604;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5604 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T;
    static long A, B;
    static long[] count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            count = new long[10];

            st = new StringTokenizer(br.readLine(), " ");
            A = Long.parseLong(st.nextToken());
            B = Long.parseLong(st.nextToken());

            long delta = 1;
            while (A <= B) {
                for (; A % 10 != 0 && A <= B; A++) {
                    calc(A, delta);
                }

                for (; B % 10 != 9 && A <= B; B--) {
                    calc(B, delta);
                }

                if (A > B) {
                    break;
                }

                A /= 10;
                B /= 10;
                long row = B - A + 1;
                for (int i = 0; i < 10; i++) {
                    count[i] += row * delta;
                }
                delta *= 10;
            }

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Long.toString(getSum()));
            bw.write("\n");
        }
        bw.flush();
    }

    private static long getSum() {
        long sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += i * count[i];
        }
        return sum;
    }

    private static void calc(long i, long delta) {
        while (i > 0) {
            count[(int) (i % 10)] += delta;
            i /= 10;
        }
    }
}