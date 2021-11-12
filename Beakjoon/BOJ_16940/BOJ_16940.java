package BOJ_16940;

import java.io.*;
import java.util.*;

public class BOJ_16940 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList[] list = new ArrayList[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(BFS(list, answer, 1) ? 1 : 0);
    }

    private static boolean BFS(ArrayList[] list, int[] answer, int start) {
        boolean[] visit = new boolean[list.length];
        HashSet<Integer> set = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            set.clear();
            int q = queue.poll();
            for (int i = 0; i < list[q].size(); i++) {
                int next = (int) list[q].get(i);
                if (!visit[next]) {
                    visit[next] = true;
                    set.add(next);
                }
            }

            int size = set.size();
            for (int i = start; i < start + size; i++) {
                if (set.contains(answer[i])) {
                    queue.add(answer[i]);
                } else {
                    return false;
                }
            }
            start += size;
        }
        return true;
    }
}