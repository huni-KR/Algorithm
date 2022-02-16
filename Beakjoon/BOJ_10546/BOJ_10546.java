package BOJ_10546;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class BOJ_10546 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (hashMap.containsKey(str)) {
                hashMap.put(str, hashMap.get(str) + 1);
            } else {
                hashMap.put(str, 1);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            String str = br.readLine();
            hashMap.put(str, hashMap.get(str) - 1);
        }

        for (Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}