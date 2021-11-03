package BOJ_21965;

import java.io.*;
import java.util.*;

public class BOJ_21965 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int top = FindMax(arr);

        System.out.println(fun(arr, top) ? "YES" : "NO");

    }

    private static int FindMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        return max;
    }

    private static boolean fun(int[] arr, int top) {
        boolean flag = true;

        if (arr[0] == top) {
            flag = false;
        }

        int tmp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (flag) {
                if (tmp >= arr[i]) {
                    return false;
                }
            } else {
                if (tmp <= arr[i]) {
                    return false;
                }
            }
            if (arr[i] == top) {
                flag = false;
            }
            tmp = arr[i];
        }
        return true;
    }
}
