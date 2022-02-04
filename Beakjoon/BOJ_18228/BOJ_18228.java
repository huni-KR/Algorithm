package BOJ_18228;

import java.io.*;
import java.util.*;

public class BOJ_18228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int pos = -1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == -1) {
                pos = i;
            }
        }

        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < pos; i++) {
            leftMin = Math.min(leftMin, arr[i]);
        }

        int rightMin = Integer.MAX_VALUE;
        rightMin = Integer.MAX_VALUE;
        for (int i = pos + 1; i < arr.length; i++) {
            rightMin = Math.min(rightMin, arr[i]);
        }

        System.out.println(leftMin + rightMin);
    }
}
