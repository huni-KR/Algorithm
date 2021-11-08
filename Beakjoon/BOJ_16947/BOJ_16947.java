package BOJ_16947;

import java.io.*;
import java.util.*;

public class BOJ_16947 {

    static Set cycleSet;
    static boolean isCycle;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        cycleSet = new HashSet<>();
        visit = new boolean[n + 1];

        List[] list = new ArrayList[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i < list.length; i++) {
            Arrays.fill(visit, false);
            isCycle = false;
            checkCycle(list, i, i, 0);

            if (isCycle) {
                cycleSet.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < list.length; i++) {
            sb.append(Integer.toString(bfs(list, i)));
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int bfs(List[] list, int start) {

        int[] distance = new int[list.length + 1];
        Arrays.fill(distance, -1);
        distance[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int q = queue.poll();
            if (cycleSet.contains(q)) {
                return distance[q];
            }

            for (int i = 0; i < list[q].size(); i++) {
                int pos = (int) list[q].get(i);
                if (distance[pos] == -1) {
                    distance[pos] = distance[q] + 1;
                    queue.add(pos);
                }
            }
        }

        return -1;
    }

    static void checkCycle(List[] list, int start, int now, int count) {
        if (start == now && count >= 2) {
            isCycle = true;
            return;
        }

        visit[now] = true;
        for (int i = 0; i < list[now].size(); i++) {
            int pos = (int) list[now].get(i);
            if (!visit[pos]) {
                checkCycle(list, start, pos, count + 1);
            } else if (start == pos && count >= 2) {
                checkCycle(list, start, pos, count);
            }
        }
    }
}

/*
 * 1. dfs 탐색 - 시작점 현재점 2. dfs 탐색하면서 방문한 노드 저장 3. 시작점 == 현재점 break 4. 사이클로 저장
 * 
 */