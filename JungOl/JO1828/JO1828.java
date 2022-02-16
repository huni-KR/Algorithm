package JO1828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class JO1828 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;

    static class Data {
        int s;
        int e;

        public int getS() {
            return this.s;
        }

        public int getE() {
            return this.e;
        }

        Data(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Data> datas = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            datas.add(new Data(s, e));
        }
        datas.sort(Comparator.comparing(Data::getE));

        boolean[] visit = new boolean[N];

        int pos = 0, count = 0;
        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }
            pos = datas.get(i).e;
            count++;
            for (int j = 0; j < N; j++) {
                if (datas.get(j).s <= pos) {
                    visit[j] = true;
                }
            }
        }

        System.out.println(count);
    }
}
