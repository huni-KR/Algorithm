package BOJ_10775;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10775 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int G, P;
    static int[] p;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        p = new int[G + 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }

        int count = 0;
        for (int i = 0; i < P; i++) {
            int pos = Integer.parseInt(br.readLine());

            if (find(pos) == 0) {
                break;
            }
            union(find(pos) - 1, pos);
            count++;
        }
        System.out.println(count);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            p[b] = a;
        }
    }

    private static int find(int a) {
        if (p[a] == a) {
            return a;
        }
        return p[a] = find(p[a]);
    }
}
