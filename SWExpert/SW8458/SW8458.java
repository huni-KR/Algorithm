package SW8458;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW8458 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, N, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[i] = Math.abs(a) + Math.abs(b);
                max = Math.max(arr[i], max);
            }

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Integer.toString(isSame() ? fun() : -1));
            bw.write("\n");
        }
        bw.flush();
    }

    private static boolean isSame() {
        for (int i = 1; i < N; i++) {
            if ((arr[0] % 2) != (arr[i] % 2)) {
                return false;
            }
        }
        return true;
    }

    private static int fun() {
        int sum = 0;
        int count = 0;
        while (true) {
            sum += count;
            if ((sum >= max) && (sum % 2) == (max % 2)) {
                return count;
            }
            count++;
        }
    }
}