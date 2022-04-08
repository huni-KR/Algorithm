package BOJ_1644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1644 {
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean[] isPrime;
    static int N;
    static int count;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        primeCheck();

        list = new ArrayList<>();
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }

        fun(0, 0, 0);

        System.out.println(count);
    }

    private static void fun(int s, int e, int sum) {

        if (sum == N) {
            count++;
            fun(s + 1, e, sum - list.get(s));
        } else if (sum > N) {
            if (s > e) {
                return;
            }
            fun(s + 1, e, sum - list.get(s));
        } else {
            if (e == list.size()) {
                return;
            }
            fun(s, e + 1, sum + list.get(e));
        }
    }

    private static void primeCheck() {
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    isPrime[i] = false;
                    break;
                }
            }
            if (isPrime[i]) {
                mark(i);
            }
        }
    }

    private static void mark(int index) {
        for (int i = index * 2; i < isPrime.length; i += index) {
            isPrime[i] = false;
        }
    }
}