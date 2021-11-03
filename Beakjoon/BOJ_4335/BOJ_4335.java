package BOJ_4335;

import java.io.*;

public class BOJ_4335 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;
        int high = 11, low = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            String command = br.readLine();
            if (command.equals("right on")) {
                if (flag) {
                    if (low < n && n < high) {
                        System.out.println("Stan may be honest");
                    } else {
                        System.out.println("Stan is dishonest");
                    }
                } else {
                    System.out.println("Stan is dishonest");
                }

                flag = true;
                high = 11;
                low = 0;
                continue;
            } else if (command.equals("too high")) {
                if (n <= high) {
                    high = n;
                } else if (n > high && low >= n) {
                    flag = false;
                }
            } else if (command.equals("too low")) {
                if (low <= n) {
                    low = n;
                } else if (low > n && high <= n) {
                    flag = false;
                }
            }
        }
    }
}
