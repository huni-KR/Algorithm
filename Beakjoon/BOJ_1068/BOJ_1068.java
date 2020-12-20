package BOJ_1068;

import java.io.*;
import java.util.*;

public class BOJ_1068 {

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int root = 0;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                list[parent].add(i);
                list[i].add(parent);
            } else {
                root = i;
            }
        }

        int target = Integer.parseInt(br.readLine());
        br.close();

        if (root != target) {
            int size = list[target].size();
            for (int i = 0; i < size; i++) {
                int tmp = list[target].get(0);

                list[target].remove(list[target].get(0));
                list[tmp].remove(list[tmp].indexOf(target));
            }

            boolean[] visit = new boolean[n];

            DFS(visit, list, root);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

    private static void DFS(boolean[] visit, ArrayList<Integer>[] list, int root) {

        visit[root] = true;
        int visitCount = 0;

        for (int tmp : list[root]) {
            if (!visit[tmp]) {
                visitCount++;
                DFS(visit, list, tmp);
            }
        }
        if (visitCount == 0)
            count++;
    }
}
