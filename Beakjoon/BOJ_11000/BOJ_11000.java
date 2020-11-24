package BOJ_11000;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Data implements Comparable<Data> {
    int s;
    int e;

    Data(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Data o) {
        return this.s - o.s;
    }

}

public class BOJ_11000 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Data[] data = new Data[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            data[i] = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();

        Arrays.sort(data);

        int count = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(data[i].e);

            if (pq.peek() <= data[i].s)
                pq.poll();

            count = Math.max(count, pq.size());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
