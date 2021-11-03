package BOJ_14217;

import java.io.*;
import java.util.*;

public class BOJ_14217 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (flag == 1) {
                list[a].add(b);
                list[b].add(a);
            } else {
                list[a].remove(list[a].indexOf(b));
                list[b].remove(list[b].indexOf(a));
            }

            System.out.println(BFS(list));
        }

    }

    private static String BFS(List<Integer>[] list) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int[] visit = new int[list.length];
        Arrays.fill(visit, Integer.MAX_VALUE);

        visit[1] = 0;
        while (!queue.isEmpty()) {

            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int q = queue.poll();

                for (int j : list[q]) {
                    if (visit[j] > visit[q] + 1) {
                        visit[j] = visit[q] + 1;
                        queue.add(j);
                    }
                }

            }
        }

        String result = "";
        for (int i = 1; i < visit.length; i++) {
            if (visit[i] == Integer.MAX_VALUE) {
                visit[i] = -1;
            }
            result += Integer.toString(visit[i]) + " ";
        }

        return result;
    }

}