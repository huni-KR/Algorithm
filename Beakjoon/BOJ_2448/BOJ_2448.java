package BOJ_2448;

import java.io.*;
import java.util.*;

public class BOJ_2448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringBuilder[] sb1 = new StringBuilder[3];
        sb1[0] = new StringBuilder("  *  ");
        sb1[1] = new StringBuilder(" * * ");
        sb1[2] = new StringBuilder("*****");

        StringBuilder[] result = fun(sb1, 3, n);

        for (int i = 0; i < result.length; i++) {
            bw.write(result[i].toString());
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static StringBuilder[] fun(StringBuilder[] sb1, int value, int n) {
        if (value == n) {
            return sb1;
        }

        StringBuilder[] sb2 = new StringBuilder[sb1.length * 2];
        for (int i = 0; i < sb2.length; i++) {
            sb2[i] = new StringBuilder();
        }

        for (int i = 0; i < sb1.length; i++) {
            for (int j = 0; j < value; j++) {
                sb2[i].append(" ");
            }
            sb2[i].append(sb1[i]);
        }

        for (int i = sb1.length; i < sb1.length * 2; i++) {
            sb2[i].append(sb1[i - sb1.length]);
            sb2[i].append(" ");
            sb2[i].append(sb1[i - sb1.length]);
        }
        for (int i = 0; i < sb1.length; i++) {
            for (int j = 0; j < sb1.length; j++) {
                sb2[i].append(" ");
            }
        }
        return fun(sb2, value * 2, n);
    }
}
