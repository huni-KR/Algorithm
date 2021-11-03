package BOJ_12026;

import java.io.*;
import java.util.*;

public class BOJ_12026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'B') {
                arr[i] = 0;
            } else if (str.charAt(i) == 'O') {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }
        }

        int[] dp = new int[n];
        for (int i = 1; i < dp.length; i++) {
            if (arr[i - 1] == 0) {

            } else if (arr[i - 1] == 1) {

            } else if (arr[i - 1] == 2) {

            }
        }
    }
}