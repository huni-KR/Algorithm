package BOJ_1914;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Stack;

public class BOJ_1914 {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        BigInteger bigInteger = new BigInteger("1");
        for (int i = 0; i < n; i++) {
            bigInteger = bigInteger.multiply(new BigInteger("2"));
        }
        bigInteger = bigInteger.subtract(new BigInteger("1"));

        System.out.println(bigInteger.toString());
        if (n <= 20) {
            move(n, 1, 2, 3);
            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static void move(int n, int start, int to, int end) {
        if (n == 0) {
            return;
        }
        move(n - 1, start, end, to);
        sb.append(Integer.toString(start));
        sb.append(" ");
        sb.append(Integer.toString(end));
        sb.append("\n");
        move(n - 1, to, start, end);
    }

}