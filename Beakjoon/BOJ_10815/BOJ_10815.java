package BOJ_10815;

import java.io.*;
import java.util.*;

public class BOJ_10815 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long[] arr1 = new long[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long[] arr2 = new long[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(fun(arr1, arr2));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String fun(long[] arr1, long[] arr2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr2.length; i++) {
            sb.append(Arrays.binarySearch(arr1, arr2[i]) < 0 ? "0 " : "1 ");
        }
        return sb.toString();
    }
}
