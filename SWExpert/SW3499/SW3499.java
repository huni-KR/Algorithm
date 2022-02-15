package SW3499;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW3499 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            String[] str = new String[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                str[i] = st.nextToken();
            }

            fun(str);

            bw.write("#" + Integer.toString(t) + " " + sb.toString() + "\n");
        }
        bw.flush();
    }

    private static void fun(String[] str) {
        String[] tmp = new String[str.length];
        int pos = 0;
        for (int i = 0; i < str.length; i += 2) {
            tmp[i] = str[pos++];
        }
        for (int i = 1; i < str.length; i += 2) {
            tmp[i] = str[pos++];
        }
        for (int i = 0; i < str.length; i++) {
            sb.append(tmp[i]);
            sb.append(" ");
        }
    }
}