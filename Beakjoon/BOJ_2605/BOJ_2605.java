package BOJ_2605;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2605 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(list.size() - Integer.parseInt(st.nextToken()), i + 1);
        }

        for (int i : list) {
            bw.write(Integer.toString(i));
            bw.write(" ");
        }
        bw.flush();
    }
}
