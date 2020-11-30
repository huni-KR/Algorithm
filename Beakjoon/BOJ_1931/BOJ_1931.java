package BOJ_1931;

import java.io.*;
import java.util.*;

class Time implements Comparable<Time> {
    int s;
    int e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        return this.s - o.s;
    }
}

public class BOJ_1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Time[] time = new Time[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();
        Arrays.sort(time);

        System.out.println();
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(time[i].s + " " + time[i].e);
        }
        System.out.println();
        System.out.println();

        int count = 1;
        int end = time[0].e;
        for (int i = 1; i < n; i++) {
            if (end > time[i].e) {
                end = time[i].e;
            } else if (end <= time[i].s) {
                end = time[i].e;
                count++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
