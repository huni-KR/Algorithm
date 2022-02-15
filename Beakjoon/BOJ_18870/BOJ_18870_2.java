package BOJ_18870;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18870_2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        List<Long> list = new ArrayList<>();
        for (Long l : set) {
            list.add(l);
        }

        Collections.sort(list);

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        for (int i = 0; i < arr.length; i++) {
            bw.write(Integer.toString(map.get(arr[i])));
            bw.write(" ");
        }
        bw.flush();
    }
}