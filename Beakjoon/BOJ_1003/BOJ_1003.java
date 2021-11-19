package BOJ_1003;

import java.io.*;

public class BOJ_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[41][2];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i][0] = arr[i - 2][0] + arr[i - 1][0];
            arr[i][1] = arr[i - 2][1] + arr[i - 1][1];
        }

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(br.readLine());
            System.out.println(arr[index][0] + " " + arr[index][1]);
        }
    }
}
