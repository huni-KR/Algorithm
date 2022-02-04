package BOJ_2447;

import java.io.*;
import java.util.*;

public class BOJ_2447 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder[] sb;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder[n];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        sb[0].append("***");
        sb[1].append("* *");
        sb[2].append("***");
        fun(3, n);
        print();

        bw.close();
        br.close();
    }

    private static void print() throws IOException {
        for (int i = 0; i < sb.length; i++) {
            bw.write(sb[i].toString());
            bw.write("\n");
        }
        bw.flush();
    }

    private static void fun(int s, int e) {
        if (s == e) {
            return;
        }

        String[] str = new String[s];
        for (int i = 0; i < s; i++) {
            str[i] = sb[i].toString();
        }

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < 2; j++) {
                sb[i].append(str[i]);
            }
        }

        for (int i = s; i < s * 2; i++) {
            sb[i].append(str[i - s]);
        }

        for (int i = s; i < s * 2; i++) {
            for (int j = 0; j < str[i - s].length(); j++) {
                sb[i].append(" ");
            }
        }

        for (int i = s; i < s * 2; i++) {
            sb[i].append(str[i - s]);
        }

        for (int i = s * 2; i < s * 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb[i].append(str[i - (s * 2)]);
            }
        }

        fun(s * 3, e);
    }
}
