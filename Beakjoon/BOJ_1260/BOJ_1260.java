package BOJ_1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.get(s).add(e);
            list.get(e).add(s);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        visit = new boolean[n + 1];
        DFS(list, v);
        bw.write("\n");
        visit = new boolean[n + 1];
        BFS(list, v);
        bw.flush();
    }

    private static void DFS(List<List<Integer>> list, int v) throws IOException {
        visit[v] = true;
        bw.write(Integer.toString(v) + " ");
        for (int i : list.get(v)) {
            if (!visit[i]) {
                DFS(list, i);
            }
        }
    }

    private static void BFS(List<List<Integer>> list, int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        bw.write(Integer.toString(v) + " ");
        visit[v] = true;

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (int i : list.get(pos)) {
                if (!visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    bw.write(Integer.toString(i) + " ");
                }
            }
        }
    }
}
