package BOJ_3673;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3673 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int T = 0; T < N; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int div = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            long[] input = new long[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    input[i] = (Long.parseLong(st.nextToken()) % div);
                } else {
                    input[i] = (input[i - 1] + Long.parseLong(st.nextToken())) % div;
                }
            }

            long result = 0;
            long[] arr = new long[div];
            arr[0] = 1;
            for (int i = 0; i < input.length; i++) {
                result += arr[(int) input[i]]++;
            }

            bw.write(Long.toString(result) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}