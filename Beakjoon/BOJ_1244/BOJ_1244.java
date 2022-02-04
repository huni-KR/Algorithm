package BOJ_1244;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1244 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < arr.length; i++) {
            int s = Integer.parseInt(st.nextToken());
            if (s == 1) {
                arr[i] = true;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                m(arr, pos);
            } else {
                w(arr, pos);
            }
        }

        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i] ? 1 : 0);
            sb.append(" ");
            if (count % 20 == 0) {
                sb.append("\n");
            }
            count++;
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void w(boolean[] arr, int pos) {
        int left = pos - 1;
        int right = pos + 1;
        while (!(left <= 0 || right >= arr.length)) {
            if (arr[left] == arr[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        for (int i = left + 1; i <= right - 1; i++) {
            arr[i] = !arr[i];
        }
    }

    private static void m(boolean[] arr, int pos) {
        for (int i = 1; i < arr.length; i++) {
            if (i % pos == 0) {
                arr[i] = !arr[i];
            }
        }
    }
}
