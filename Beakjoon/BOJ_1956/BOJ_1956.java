package BOJ_1956;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1956 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int V, E;
    static int[][] arr;
    static boolean[] visit;

    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(arr[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            arr[a][b] = w;
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    arr[i][k] = Math.min(arr[i][k], arr[i][j] + arr[j][k]);
                }
            }
        }

        int result = find();
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static int find() {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (arr[i][j] != INF && arr[j][i] != INF) {
                    result = Math.min(result, arr[i][j] + arr[j][i]);
                }
            }
        }
        return result;
    }
}

// public class BOJ_1956 {
// static BufferedReader br;
// static BufferedWriter bw;
// static StringTokenizer st;
// static int V, E;
// static List<List<Data>> list;
// static int[] min;
// static boolean[] visit;

// static class Data {
// int end;
// int weigth;

// Data(int end, int weigth) {
// this.end = end;
// this.weigth = weigth;
// }
// }

// public static void main(String[] args) throws IOException {
// br = new BufferedReader(new InputStreamReader(System.in));
// bw = new BufferedWriter(new OutputStreamWriter(System.out));
// st = new StringTokenizer(br.readLine(), " ");

// V = Integer.parseInt(st.nextToken());
// E = Integer.parseInt(st.nextToken());

// list = new ArrayList<>();
// for (int i = 0; i <= V; i++) {
// list.add(new ArrayList<>());
// }

// for (int i = 0; i < E; i++) {
// st = new StringTokenizer(br.readLine(), " ");
// int a = Integer.parseInt(st.nextToken());
// int b = Integer.parseInt(st.nextToken());
// int w = Integer.parseInt(st.nextToken());

// list.get(a).add(new Data(b, w));
// }

// min = new int[V + 1];
// Arrays.fill(min, Integer.MAX_VALUE);

// for (int i = 1; i <= V; i++) {
// visit = new boolean[V + 1];
// DFS(i, i, 0);
// }

// int result = find();
// System.out.println(result == Integer.MAX_VALUE ? -1 : result);
// }

// private static int find() {
// int result = Integer.MAX_VALUE;
// for (int i = 1; i <= V; i++) {
// result = Math.min(result, min[i]);
// }
// return result;
// }

// private static void DFS(int start, int now, int weight) {
// if (weight != 0 && start == now) {
// min[start] = Math.min(min[start], weight);
// return;
// }

// for (Data data : list.get(now)) {
// int pos = data.end;
// int w = data.weigth;

// if (!visit[pos]) {
// visit[pos] = true;
// DFS(start, pos, weight + w);
// visit[pos] = false;
// }
// }
// }
// }
