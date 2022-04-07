package BOJ_17471;

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

public class BOJ_17471 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, min;
    static int[] arr;
    static boolean[] color, visit;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int a = Integer.parseInt(st.nextToken());

                if (!list.get(i).contains(a)) {
                    list.get(i).add(a);
                }

                if (!list.get(a).contains(i)) {
                    list.get(a).add(i);
                }
            }
        }

        min = Integer.MAX_VALUE;
        color = new boolean[N + 1];
        fun(0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void fun(int depth) {

        if (depth == N) {
            return;
        }

        List<Integer> data = color();
        if (data.size() == 2) {
            min = Math.min(min, Math.abs(data.get(0) - data.get(1)));
        }

        color[depth + 1] = true;
        fun(depth + 1);
        color[depth + 1] = false;
        fun(depth + 1);
    }

    private static List<Integer> color() {
        List<Integer> result = new ArrayList<>();
        visit = new boolean[N + 1];
        for (int i = 1; i < color.length; i++) {
            if (!visit[i]) {
                result.add(BFS(i));
            }
        }
        return result;
    }

    private static int BFS(int pos) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);
        visit[pos] = true;

        int sum = arr[pos];
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < list.get(now).size(); i++) {
                int tmp = list.get(now).get(i);
                if (!visit[tmp] && color[tmp] == color[pos]) {
                    visit[tmp] = true;
                    queue.add(tmp);
                    sum += arr[tmp];
                }
            }
        }
        return sum;
    }
}