package BOJ_1318;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BOJ_1318 {
    static BufferedWriter bw;
    static long[][] arr;

    public static void main(String[] args) {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new long[53][53];
        arr[1][0] = 1;
        arr[1][1] = 1;
        for (int i = 2; i < 53; i++) {
            arr[i][0] = 1;
            for (int j = 1; j < 53; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
    }
}
