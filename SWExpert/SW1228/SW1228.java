package SW1228;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SW1228 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            List<String> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(st.nextToken());
            }

            int command = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < command; c++) {
                String order = st.nextToken();
                int pos = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                for (int i = 0; i < count; i++) {
                    list.add(pos + i, st.nextToken());
                }
            }

            bw.write("#" + Integer.toString(t) + " ");
            for (int i = 0; i < 10; i++) {
                bw.write(list.get(i) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}