package BOJ_14402;

import java.io.*;
import java.util.*;

public class BOJ_14402 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String op = st.nextToken();
            if (op.equals("+")) {
                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + 1);
                } else {
                    map.put(name, 1);
                }
            } else {
                if (map.containsKey(name) && map.get(name) > 0) {
                    map.put(name, map.get(name) - 1);
                } else {
                    count++;
                }
            }
        }

        for (int value : map.values()) {
            count += value;
        }
        System.out.println(count);
    }
}