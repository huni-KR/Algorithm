package BOJ_21967;

import java.io.*;
import java.util.*;

public class BOJ_21967 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i], min = arr[i];
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if ((max - min) > 2) {
                    break;
                }
                count++;
            }
            result[i] = count;
        }
        int max = 0;
        for (int i = 0; i < result.length; i++) {
            max = Math.max(max, result[i]);
        }

        System.out.println(max);
    }
}
