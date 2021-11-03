package BOJ_2851;

import java.io.*;

public class BOJ_2851 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[11];
        for (int i = 1; i < 11; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(br.readLine());
        }

        int result = 0;
        int tmp = 1000;
        for (int i = 1; i < 11; i++) {
            if (Math.abs(100 - arr[i]) <= tmp) {
                tmp = Math.abs(100 - arr[i]);
                result = arr[i];
            }
        }
        System.out.println(result);
    }
}
