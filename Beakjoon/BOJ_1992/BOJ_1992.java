package BOJ_1992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1992 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        sb = new StringBuilder();
        fun(0, 0, N);

        System.out.println(sb.toString());
    }

    private static void fun(int x, int y, int len) {
        int part1 = check(x, y, len / 2);
        int part2 = check(x + len / 2, y, len / 2);
        int part3 = check(x, y + len / 2, len / 2);
        int part4 = check(x + len / 2, y + len / 2, len / 2);

        if (part1 != -1 && part1 == part2 && part2 == part3 && part3 == part4) {
            sb.append(Integer.toString(part1));
        } else {

            if (len == 1) {
                sb.append("(");
                sb.append(Integer.toString(part1));
                sb.append(Integer.toString(part2));
                sb.append(Integer.toString(part3));
                sb.append(Integer.toString(part4));
                sb.append(")");
            } else {
                sb.append("(");

                if (part1 != -1) {
                    sb.append(Integer.toString(part1));
                } else {
                    fun(x, y, len / 2);
                }

                if (part2 != -1) {
                    sb.append(Integer.toString(part2));
                } else {
                    fun(x + len / 2, y, len / 2);
                }

                if (part3 != -1) {
                    sb.append(Integer.toString(part3));
                } else {
                    fun(x, y + len / 2, len / 2);
                }

                if (part4 != -1) {
                    sb.append(Integer.toString(part4));
                } else {
                    fun(x + len / 2, y + len / 2, len / 2);
                }

                sb.append(")");
            }
        }
    }

    private static int check(int x, int y, int len) {
        int start = arr[y][x];
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (start != arr[i][j]) {
                    return -1;
                }
            }
        }
        return start;
    }
}