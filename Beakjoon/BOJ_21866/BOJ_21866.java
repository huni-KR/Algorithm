package BOJ_21866;

import java.io.*;
import java.util.*;

public class BOJ_21866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] max = new int[] { 100, 100, 200, 200, 300, 300, 400, 400, 500 };

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        if (isHacker(max, arr)) {
            System.out.println("hacker");
        } else {
            if (sum >= 100) {
                System.out.println("draw");
            } else {
                System.out.println("none");
            }
        }
    }

    private static boolean isHacker(int[] max, int[] arr) {
        for (int i = 0; i < max.length; i++) {
            if (max[i] < arr[i]) {
                return true;
            }
        }
        return false;
    }
}
