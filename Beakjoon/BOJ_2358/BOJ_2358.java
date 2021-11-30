package BOJ_2358;

import java.io.*;
import java.util.*;

public class BOJ_2358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Long> xHashMap = new HashMap<>();
        HashMap<Long, Long> yHashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            if (xHashMap.containsKey(x)) {
                xHashMap.put(x, xHashMap.get(x) + 1);
            } else {
                xHashMap.put(x, (long) 1);
            }

            if (yHashMap.containsKey(y)) {
                yHashMap.put(y, yHashMap.get(y) + 1);
            } else {
                yHashMap.put(y, (long) 1);
            }
        }

        long count = 0;
        for (long i : xHashMap.keySet()) {
            if (xHashMap.get(i) > 1) {
                count++;
            }
        }
        for (long i : yHashMap.keySet()) {
            if (yHashMap.get(i) > 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}