package BOJ_2407;

import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            a = a.multiply(new BigInteger(String.valueOf(n - i)));
            b = b.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        System.out.println(a.divide(b));
    }
}