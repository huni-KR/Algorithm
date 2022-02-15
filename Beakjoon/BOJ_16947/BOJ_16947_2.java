package BOJ_16947;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_16947_2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, point;
    static boolean[] visit, isCycle;
    static boolean cycle, checkPoint;
    static int[] distance;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }

        isCycle = new boolean[n + 1];
        distance = new int[n + 1];

        visit = new boolean[n + 1];
        stack = new Stack<>();
        dfs(list, 1, -1);

        for (int i = 1; i < isCycle.length; i++) {
            if (!isCycle[i]) {
                visit = new boolean[n + 1];
                bfs(list, i);
            }
        }

        for (int i = 1; i < distance.length; i++) {
            bw.write(Integer.toString(distance[i]));
            bw.write(" ");
        }
        bw.flush();
    }

    private static void bfs(ArrayList<ArrayList<Integer>> list, int pos) {
        visit[pos] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);

        int len = 0;
        while (!queue.isEmpty()) {

            int qsize = queue.size();
            for (int i = 0; i < qsize; i++) {
                int now = queue.poll();

                if (isCycle[now]) {
                    distance[pos] = len;
                    return;
                }

                for (int k : list.get(now)) {
                    if (!visit[k]) {
                        visit[k] = true;
                        queue.add(k);
                    }
                }
            }
            len++;
        }

    }

    private static void dfs(ArrayList<ArrayList<Integer>> list, int pos, int last) {
        visit[pos] = true;
        for (int i = 0; i < list.get(pos).size(); i++) {
            int now = list.get(pos).get(i);
            if (!visit[now]) {
                dfs(list, now, pos);
                if (cycle) {
                    if (now == point) {
                        checkPoint = false;
                    }

                    if (checkPoint) {
                        isCycle[now] = true;
                    }
                    return;
                }
            } else if (visit[now] && now != last) {
                cycle = true;
                checkPoint = true;
                point = now;
                isCycle[now] = true;
                return;
            }
        }
    }
}