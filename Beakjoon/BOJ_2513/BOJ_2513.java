package BOJ_2513;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2513 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K, S, min, max;
    static int[] arr;
    static long result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }

        min = 1000001;
        min = findMin();

        max = 0;
        max = findMax();

        result = 0;
        fun();

        System.out.println(result);
    }

    private static int findMin() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    private static int findMax() {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    private static void fun() {
        left();
        right();
    }

    private static void left() {
        int now = 0;
        int pos = -1;
        for (int i = min; i < S; i++) {
            if (arr[i] > 0) {
                if (K > now + arr[i]) {
                    now += arr[i];
                    arr[i] = 0;
                    if (pos == -1) {
                        pos = i;
                    }
                } else {
                    arr[i] -= (K - now);
                    now += (K - now);

                    if (pos != -1) {
                        result += (S - pos) * 2;
                    } else {
                        result += (S - i) * 2;
                    }
                    now = 0;
                    pos = -1;
                    i--;
                }
            }
        }
        if (pos != -1) {
            result += (S - pos) * 2;
        }
    }

    private static void right() {
        int now = 0;
        int pos = -1;
        for (int i = max; i > S; i--) {
            if (arr[i] > 0) {
                if (K > now + arr[i]) {
                    now += arr[i];
                    arr[i] = 0;
                    if (pos == -1) {
                        pos = i;
                    }
                } else {
                    arr[i] -= (K - now);
                    now += (K - now);

                    if (pos != -1) {
                        result += (pos - S) * 2;
                    } else {
                        result += (i - S) * 2;
                    }
                    now = 0;
                    pos = -1;
                    i++;
                }
            }
        }
        if (pos != -1) {
            result += (pos - S) * 2;
        }
    }
}