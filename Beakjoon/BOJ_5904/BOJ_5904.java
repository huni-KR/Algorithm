package BOJ_5904;

import java.io.*;

public class BOJ_5904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder mo = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        mo.append("moo");
        sb.append(mo);

        while (sb.length() < n) {
            mo.append("o");
            String str = sb.toString();
            sb.append(mo);
            sb.append(str);
        }
        System.out.println(sb.toString().charAt(n - 1));
    }
}
