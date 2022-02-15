package BOJ_9663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9663 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N, sum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        sum = 0;
        fun(0);
        System.out.println(sum);
    }

    private static void fun(int count) {
        if (count == N) {
            sum++;
            return;
        }

        
    }
}
