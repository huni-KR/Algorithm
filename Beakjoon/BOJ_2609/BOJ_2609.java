package BOJ_2609;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2609 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][a > b ? a + 1 : b + 1];
        arr[0][1] = 1;
        arr[1][1] = 1;
        int value = 2;
        while (a != 1) {
            if (a % value == 0) {
                a /= value;
                arr[0][value]++;
            } else {
                value++;
            }
        }

        value = 2;
        while (b != 1) {
            if (b % value == 0) {
                b /= value;
                arr[1][value]++;
            } else {
                value++;
            }
        }

        int min = 1;
        int max = 1;
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] != 0 && arr[1][i] != 0) {
                min *= Math.pow(i, Math.min(arr[0][i], arr[1][i]));
                max *= Math.pow(i, Math.max(arr[0][i], arr[1][i]));
            } else if (arr[0][i] != 0 || arr[1][i] != 0) {
                max *= Math.pow(i, Math.max(arr[0][i], arr[1][i]));
            }
        }

        System.out.println(min);
        System.out.println(max);

    }
}