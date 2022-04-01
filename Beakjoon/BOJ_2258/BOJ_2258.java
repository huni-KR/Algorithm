package BOJ_2258;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2258 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[][] arr;
    static List<Data> data;

    static class Data {
        int w;
        int v;

        Data(int w, int v) {
            this.w = w;
            this.v = v;
        }

        public int getV() {
            return v;
        }

        public int getW() {
            return w;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            data.add(new Data(w, v));
        }

        data.sort(Comparator.comparing(Data::getV).thenComparing(Data::getW));

        int result = -1;
        int total = data.get(0).w;
        int sum = 0;
        int value = data.get(0).v;
        boolean flag = false;
        for (int i = 1; i < data.size() - 1; i++) {
            sum += data.get(i).w;
            if (value < data.get(i).v && data.get(i).v < data.get(i + 1).v) {
                value = data.get(i).v;
                total += sum;
                sum = 0;
                if (total >= M) {
                    flag = true;
                    result = data.get(i).v;
                    break;
                }
            } else {
                if (total + data.get(i).w >= M) {
                    flag = true;
                    result = data.get(i).v;
                    break;
                }
            }
        }

        if (!flag && value < data.get(data.size() - 1).v) {
            total += data.get(data.size() - 1).w;
            if (total >= M) {
                flag = true;
                result = data.get(data.size() - 1).v;
            }
        }

        System.out.println(result);
    }
}