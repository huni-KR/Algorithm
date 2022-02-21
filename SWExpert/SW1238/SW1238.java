package SW1238;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1238 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, count;
    static List<List<Integer>> list;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 10;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int i = 0; i <= 100; i++) {
                list.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N / 2; i++) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                list.get(s).add(e);
            }

            visit = new int[101];
            Arrays.fill(visit, -1);
            count = 0;
            BFS(start);

            int index = finder();

            bw.write("#" + Integer.toString(t) + " " + Integer.toString(index) + "\n");
        }
        bw.flush();
    }

    private static int finder() {
        int max = 0, index = 0;
        for (int i = visit.length - 1; i >= 0; i--) {
            if (max < visit[i]) {
                max = visit[i];
                index = i;
            }
        }
        return index;
    }

    private static void BFS(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visit[v] = count++;

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (int i : list.get(pos)) {
                if (visit[i] == -1) {
                    queue.add(i);
                    visit[i] = visit[pos] + 1;
                }
            }
        }
    }
}
