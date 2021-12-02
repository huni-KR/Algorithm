package BOJ_1967;

import java.io.*;
import java.util.*;

public class BOJ_1967 {

    static class Data {
        int e;
        int w;

        Data(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Data>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(s).add(new Data(e, w));
            list.get(e).add(new Data(s, w));
        }

        int[] dp1 = BFS(list, 1);
        int index = findMaxIndex(dp1);

        int[] dp2 = BFS(list, index);
        System.out.println(dp2[findMaxIndex(dp2)]);
    }

    private static int findMaxIndex(int[] dp) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                index = i;
                max = dp[i];
            }
        }
        return index;
    }

    private static int[] BFS(ArrayList<ArrayList<Data>> list, int start) {
        int[] visit = new int[list.size()];
        Arrays.fill(visit, -1);
        visit[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (Data data : list.get(pos)) {
                int now = data.e;
                if (visit[now] == -1) {
                    visit[now] = visit[pos] + data.w;
                    queue.add(now);
                }
            }
        }
        return visit;
    }
}