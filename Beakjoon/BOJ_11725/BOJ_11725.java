package BOJ_11725;

import java.io.*;
import java.util.*;

public class BOJ_11725 {
    static int[] parent;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        parent = new int[n + 1];
        visit = new boolean[n + 1];
        BFS(list, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parent.length; i++) {
            sb.append(Integer.toString(parent[i]));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(ArrayList<ArrayList<Integer>> list, int pos) {
        Queue<Integer> queue = new LinkedList<>();
        visit[pos] = true;
        queue.add(pos);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : list.get(now)) {
                if (!visit[i]) {
                    parent[i] = now;
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
