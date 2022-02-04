package BOJ_1931;

import java.io.*;
import java.util.*;

public class BOJ_1931_2 {

    static class Time {
        int s;
        int e;

        Time(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int getS() {
            return this.s;
        }

        public int getE() {
            return this.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Time> time = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        time.sort(Comparator.comparing(Time::getE).thenComparing(Time::getS));

        int cur = 0;
        int count = 0;
        for (Time t : time) {
            if (t.s >= cur) {
                cur = t.e;
                count++;
            }
        }
        System.out.println(count);
    }
}