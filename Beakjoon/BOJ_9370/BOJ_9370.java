package BOJ_9370;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9370 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int X, Y;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            st = new StringTokenizer(br.readLine(), " ");
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            if (X > Y) {
                int tmp = X;
                tmp = Y;
                Y = tmp;
            }

            double max = 0;
            double pos = 0;
            for (double h = X / 6.0; h < X / 2.0; h += 0.0001) {
                if (max < h * (X - 2 * h) * (Y - 2 * h)) {
                    max = h * (X - 2 * h) * (Y - 2 * h);
                    pos = h;
                }
            }
            System.out.println(pos);

            System.out.printf("#%d %.6f\n", c + 1, max);

        }

    }

}
