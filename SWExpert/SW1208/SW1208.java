package SW1208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                arr[0]++;
                arr[99]--;
                Arrays.sort(arr);
            }
            bw.write("#" + Integer.toString(t + 1) + " " + Integer.toString(arr[99] - arr[0]) + "\n");
        }
        bw.flush();
    }
}