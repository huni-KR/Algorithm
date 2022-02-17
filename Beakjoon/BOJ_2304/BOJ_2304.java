package BOJ_2304;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2304 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][1001];

        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int pos = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[0][pos] = value;

            max = Math.max(max, pos);
            min = Math.min(min, pos);
        }

        int s = min, e = max;

        int top = 0;
        for (int i = s; i <= e; i++) {
            top = Math.max(top, arr[0][i]);
            arr[1][i] = top;
        }

        top = 0;
        for (int i = e; i >= s; i--) {
            top = Math.max(top, arr[0][i]);
            arr[2][i] = top;
        }

        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += Math.min(arr[1][i], arr[2][i]);
        }
        System.out.println(sum);
    }
}
