package BOJ_12904;

import java.io.*;

public class BOJ_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder A = new StringBuilder(br.readLine());
        StringBuilder B = new StringBuilder(br.readLine());
        while (A.length() < B.length()) {
            if (B.charAt(B.length() - 1) == 'A') {
                B.deleteCharAt(B.length() - 1);
            } else {
                B.deleteCharAt(B.length() - 1);
                B.reverse();
            }
        }
        System.out.println(B.toString().equals(A.toString()) ? 1 : 0);
    }
}