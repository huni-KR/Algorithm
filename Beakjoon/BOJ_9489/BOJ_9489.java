package BOJ_9489;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9489 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] arr, parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (N == 0 && K == 0) {
                break;
            }

            if (N < 5) {
                bw.write("0\n");
                br.readLine();
                continue;
            }

            arr = new int[N + 1];

            int KIndex = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == K) {
                    KIndex = i;
                }
            }

            parent = new int[N + 1];
            Arrays.fill(parent, -1);
            int pos = 0;
            for (int i = 2; i < parent.length; i++) {
                if (arr[i - 1] + 1 == arr[i]) {
                    parent[i] = pos;
                } else {
                    pos++;
                    parent[i] = pos;
                }
            }

            int tmp = parent[KIndex];
            int count = 0;
            for (int i = 2; i < parent.length; i++) {
                if (parent[tmp] == parent[parent[i]]) {
                    if (tmp != parent[i]) {
                        count++;
                    }
                }
            }

            bw.write(Integer.toString(count));
            bw.write("\n");
        }
        bw.flush();
    }
}