package JO2577;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class JO2577 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, D, K, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        // 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N + K];
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            if (i < K) {
                arr[i + N] = value;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            if (map.containsKey(arr[i])) {
                int value = map.get(arr[i]);
                map.put(arr[i], value + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int value = map.get(arr[i - 1]);
            if (value > 1) {
                map.put(arr[i - 1], value - 1);
            } else {
                map.remove(arr[i - 1]);
            }

            if (map.containsKey(arr[i + K - 1])) {
                int tmp = map.get(arr[i + K - 1]);
                map.put(arr[i + K - 1], tmp + 1);
            } else {
                map.put(arr[i + K - 1], 1);
            }

            if (map.containsKey(C)) {
                max = Math.max(max, map.size());
            } else {
                max = Math.max(max, map.size() + 1);
            }
        }

        System.out.println(max);
    }
}

// 투포인터?
