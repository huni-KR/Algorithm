package SW1225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1225 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;
        for (int t = 1; t <= T; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[8];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < arr.length; i++) {
                queue.add(arr[i]);
            }

            boolean flag = true;
            while (flag) {
                for (int i = 1; i <= 5; i++) {
                    int now = queue.poll();
                    if (now - i <= 0) {
                        flag = false;
                        queue.add(0);
                        break;
                    } else {
                        queue.add(now - i);
                    }
                }
            }

            bw.write("#");
            bw.write(Integer.toString(t));
            bw.write(" ");
            while (!queue.isEmpty()) {
                bw.write(Integer.toString(queue.poll()));
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();

    }
}