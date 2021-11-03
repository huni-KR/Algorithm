package BOJ_2293;

import java.io.*;
import java.util.*;

public class BOJ_2293 {

    static int n, k;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        result = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        result[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                result[j] = result[j] + result[j - arr[i]];
            }
        }
        System.out.println(result[k]);
    }
}
