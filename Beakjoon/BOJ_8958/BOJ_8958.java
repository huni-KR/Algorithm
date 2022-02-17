package BOJ_8958;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_8958 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int sum = 0;
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == 'O') {
                    sum += ++count;
                } else {
                    count = 0;
                }
            }
            System.out.println(sum);
        }
    }
}
