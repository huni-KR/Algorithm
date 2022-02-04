package BOJ_18228;

import java.io.*;
import java.util.*;

public class BOJ_18228_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int pos = 0;
        int[] min = { Integer.MAX_VALUE, Integer.MAX_VALUE };
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == -1) {
                pos++;
                continue;
            }
            min[pos] = Math.min(min[pos], tmp);
        }
        System.out.println(min[0] + min[1]);
    }
}