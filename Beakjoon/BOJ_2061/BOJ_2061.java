package BOJ_2061;

import java.io.*;
import java.util.*;

public class BOJ_2061 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String k = st.nextToken();
        int l = Integer.parseInt(st.nextToken());
        br.close();

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < l; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    break;
                }
            }
        }
    }
}
