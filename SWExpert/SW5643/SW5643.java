package SW5643;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5643 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int T, N, M;
    static boolean[] visit;
    static int[] count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            List<List<Integer>> listA = new ArrayList<>();
            List<List<Integer>> listB = new ArrayList<>();
            for (int i = 0; i < N + 1; i++) {
                listA.add(new ArrayList<>());
                listB.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // a가 작고 b가 큼
                listA.get(a).add(b);
                listB.get(b).add(a);
            }

            count = new int[N + 1];

            for (int i = 1; i < listA.size(); i++) {
                visit = new boolean[N + 1];
                BFS(listA, i);
                visit = new boolean[N + 1];
                BFS(listB, i);
            }

            int result = 0;
            for (int i = 1; i < count.length; i++) {
                if (count[i] == N - 1) {
                    result++;
                }
            }

            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Integer.toString(result));
            bw.write("\n");
        }
        bw.flush();
    }

    private static void BFS(List<List<Integer>> list, int pos) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);
        visit[pos] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < list.get(now).size(); i++) {
                int tmp = list.get(now).get(i);

                if (!visit[tmp]) {
                    visit[tmp] = true;
                    count[tmp]++;
                    queue.add(tmp);
                }
            }
        }
    }
}