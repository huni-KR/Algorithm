package SW9229;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW9229 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n, m;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n];
            visit = new boolean[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = fun(0, 0);
            bw.write("#" + Integer.toString(t) + " " + Integer.toString(max) + "\n");
        }
        bw.flush();
    }

    private static int fun(int pos, int count) {
        int max = -1;
        if (count == 2) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visit[i]) {
                    sum += arr[i];
                }
            }
            return sum <= m ? sum : -1;
        }
        for (int i = pos; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                max = Math.max(max, fun(i + 1, count + 1));
                visit[i] = false;
            }
        }
        return max;
    }

}