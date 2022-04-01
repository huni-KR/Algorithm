package BOJ_7662;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_2 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int T;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String oper = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if (oper.equals("I")) {
                    treeMap.put(value, treeMap.getOrDefault(value, 0) + 1);
                } else {
                    if (treeMap.size() > 0) {
                        int key = (value == 1 ? treeMap.lastKey() : treeMap.firstKey());

                        // treeMap에서 key의 value가 1이면 remove하는 코드

                        // code 1
                        if (treeMap.put(key, treeMap.get(key) - 1) == 1) {
                            treeMap.remove(key);
                        }

                        // code 2
                        if (treeMap.get(key) == 1) {
                            treeMap.remove(key);
                        }
                    }
                }
            }

            sb.append(treeMap.isEmpty() ? "EMPTY"
                    : (Integer.toString(treeMap.lastKey()) + " " + Integer.toString(treeMap.firstKey())));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}