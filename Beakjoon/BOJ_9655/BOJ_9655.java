package BOJ_9655;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9655 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        // true SK false CY
        boolean[] arr = new boolean[N + 1];
        if (N == 1) {
            System.out.println("SK");
        } else if (N == 2) {
            System.out.println("CY");
        } else if (N == 2) {
            System.out.println("SK");
        } else {
            arr[1] = true;
            arr[2] = false;
            arr[3] = true;
            for (int i = 4; i < arr.length; i++) {
                arr[i] = !arr[i - 1];
            }
            System.out.println(arr[N] ? "SK" : "CY");
        }

    }
}
