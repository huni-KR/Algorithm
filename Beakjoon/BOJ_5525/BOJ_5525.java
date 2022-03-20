package BOJ_5525;

import java.io.*;

public class BOJ_5525 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int sum = 0;
        int count = arr[0] == 'I' ? 1 : 0;
        char last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (last == arr[i]) {
                count -= arr[i] == 'O' ? 1 : 0;

                int tmp = count / 2 - N + 1;
                if (tmp > 0) {
                    sum += tmp;
                }
                count = arr[i] == 'I' ? 1 : 0;
            } else {
                count++;
            }
            last = arr[i];
        }

        count -= arr[M - 1] == 'O' ? 1 : 0;
        int tmp = count / 2 - N + 1;
        if (tmp > 0) {
            sum += tmp;
        }

        System.out.println(sum);
    }
}
