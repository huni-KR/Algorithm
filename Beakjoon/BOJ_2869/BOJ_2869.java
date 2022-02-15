package BOJ_2869;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long up = Long.parseLong(st.nextToken());
        long down = Long.parseLong(st.nextToken());
        long total = Long.parseLong(st.nextToken());

        long days = (total - up) / (up - down);
        days += (total - up) % (up - down) == 0 ? 0 : 1;
        System.out.println(days + 1);
    }
}
