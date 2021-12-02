package BOJ_1005;

import java.io.*;
import java.util.*;

public class BOJ_1005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(b).add(a);
            }

            int w = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];
            dp[w] = arr[w];

            BFS(list, arr, dp, w);

            bw.write(Integer.toString(findMax(dp)));
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    private static int findMax(int[] dp) {
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static void BFS(ArrayList<ArrayList<Integer>> list, int[] arr, int[] dp, int w) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(w);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (int i : list.get(pos)) {
                if (dp[i] < dp[pos] + arr[i]) {
                    dp[i] = dp[pos] + arr[i];
                    queue.add(i);
                }
            }
        }
    }

}
