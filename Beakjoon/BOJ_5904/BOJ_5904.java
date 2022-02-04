package BOJ_5904;

import java.io.*;

public class BOJ_5904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        StringBuilder moo = new StringBuilder("moo");
        StringBuilder sb = new StringBuilder();
        sb.append(moo);

        while (sb.length() <= N) {
            String tmp = sb.toString();
            sb.append(moo);
            sb.append("o");
            sb.append(tmp);
            moo.append("o");
        }

        System.out.println(sb.charAt((int) N - 1));
    }
}