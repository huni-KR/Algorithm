package BOJ_4344;

import java.io.*;
import java.util.*;

public class BOJ_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            double[] arr = new double[n];
            double sum = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Double.parseDouble(st.nextToken());
                sum += arr[i];
            }
            double avg = sum / (double) n;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (avg < arr[i]) {
                    count++;
                }
            }
            double result = Math.round(((double) count / (double) n) * 100000);

            System.out.printf("%.3f", result / (double) 1000);
            System.out.println("%");

        }
    }
}
