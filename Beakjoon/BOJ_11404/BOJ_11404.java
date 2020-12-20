package BOJ_11404;

import java.io.*;
import java.util.*;

public class BOJ_11404 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nV = Integer.parseInt(br.readLine());
        int nE = Integer.parseInt(br.readLine());

        int[][] arr = new int[nV + 1][nV + 1];

        for (int i = 1; i < arr.length; i++) {
            Arrays.fill(arr[i], 10000000);
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i][i] = 0;
        }

        for (int i = 0; i < nE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[s][e] = Math.min(arr[s][e], w);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int k = 1; k < arr.length; k++) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j < arr.length; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j] >= 10000000) {
                    bw.write("0 ");
                } else {
                    bw.write(Integer.toString(arr[i][j]) + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}