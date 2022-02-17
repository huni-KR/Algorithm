package BOJ_8320;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_8320_2 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                if (i * j <= N) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}