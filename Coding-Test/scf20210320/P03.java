import java.io.*;
import java.util.*;

public class P03 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = findValue(arr, i, j);
                    }
                    max = Math.max(arr[i][j], max);
                }
            }
        }

        int[] result = new int[max];
        int target = 1;
        for (int a = 0; a < max; a++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] >= target) {
                        sum++;
                    }
                }
            }
            result[target - 1] = sum;
            target++;
        }

        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }

        System.out.println("total: " + sum);
        for (int i = 0; i < max; i++) {
            System.out.println("size[" + (i + 1) + "]: " + result[i]);
        }
    }

    private static int findValue(int[][] arr, int i, int j) {
        int min = Integer.MAX_VALUE;
        min = Math.min(arr[i - 1][j - 1], min);
        min = Math.min(arr[i][j - 1], min);
        min = Math.min(arr[i - 1][j], min);
        return min + 1;
    }
}