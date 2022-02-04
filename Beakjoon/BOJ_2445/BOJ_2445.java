package BOJ_2445;

import java.io.*;
import java.util.*;

public class BOJ_2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            for (int j = i + 1; j <= 2 * n - i; j++) {
                sb.append(" ");
            }
            for (int j = n - i; j < n; j++) {
                sb.append("*");
            }
            arr[i] = sb.toString();
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }
        for (int i = n - 1; i > 0; i--) {
            System.out.println(arr[i]);
        }
    }
}