package BOJ_1759;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int L, C;
    static char[] arr;
    static int[] pos;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = br.readLine().replace(" ", "").toCharArray();
        pos = new int[L];
        visit = new boolean[arr.length];

        Arrays.sort(arr);

        fun(0);
        bw.flush();
    }

    private static void fun(int depth) throws IOException {
        if (depth == L) {
            if (check()) {
                for (int i = 0; i < pos.length; i++) {
                    bw.write(arr[pos[i]]);
                }
                bw.write("\n");
            }
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            pos[depth] = i;
            fun(depth + 1);
            visit[i] = false;
        }

    }

    private static boolean check() {
        int aeiou = 0;
        int another = 0;
        for (int i = 0; i < pos.length; i++) {
            if (arr[pos[i]] == 'a' || arr[pos[i]] == 'e' || arr[pos[i]] == 'i' || arr[pos[i]] == 'o'
                    || arr[pos[i]] == 'u') {
                aeiou++;
            } else {
                another++;
            }
        }

        if (!(aeiou > 0 && another > 1)) {
            return false;
        }

        int num = arr[pos[0]];
        for (int i = 1; i < pos.length; i++) {
            if (num < arr[pos[i]]) {
                num = arr[pos[i]];
            } else {
                return false;
            }            
        }
        return true;
    }
}