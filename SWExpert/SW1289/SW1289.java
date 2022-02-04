package SW1289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1289 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            char[] arr = br.readLine().toCharArray();
            int count = 0;

            char last = arr[0];

            if (last == '1') {
                count++;
            }
            
            for (int i = 1; i < arr.length; i++) {
                if (last != arr[i]) {
                    count++;
                }
                last = arr[i];
            }

            System.out.printf("#%d %d\n", t + 1, count);
        }
    }
}