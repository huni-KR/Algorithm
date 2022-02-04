package BOJ_15686;

import java.io.*;
import java.util.*;

public class BOJ_15686 {

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Data {
        int index;
        int dist;

        Data(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        public int getDist() {
            return dist;
        }

        public int getIndex() {
            return index;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        List<Pos> house = new ArrayList<>();
        List<Pos> chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    house.add(new Pos(j, i));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Pos(j, i));
                }
            }
        }
        
    }
}
