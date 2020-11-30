package BOJ_1812;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1812 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(br.readLine());
        br.close();

        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        sum /= 2;
        for (int i = 1; i < arr.length; i += 2)
            sum -= arr[i];

        int[] result = new int[n];
        result[0] = sum;
        result[n - 1] = arr[n - 1] - result[0];
        for (int i = 1; i < result.length - 1; i++)
            result[i] = arr[i - 1] - result[i - 1];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < result.length; i++)
            bw.write(Integer.toString(result[i]) + "\n");
        bw.flush();
        bw.close();
    }
}
