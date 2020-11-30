package BOJ_3991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3991 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int[][] grid = new int[y][x];

        int[] color = new int[num];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < color.length; i++)
            color[i] = Integer.parseInt(st.nextToken());

        int pos = 0;
        boolean flag = true;
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < color[i]; j++) {
                if (flag) {
                    grid[pos / x][pos % x] = i + 1;
                    pos++;
                    if (pos % x == 0) {
                        flag = !flag;
                        pos += x - 1;
                    }
                } else {
                    grid[pos / x][pos % x] = i + 1;
                    pos--;
                    if (pos % x == x - 1) {
                        flag = !flag;
                        pos += x + 1;
                    }
                }

            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
