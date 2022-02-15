package SW1861;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SW1861 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static HashMap<Integer, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    hashMap.put(arr[i][j], fun(arr[i][j], i, j, 1));
                }
            }

            int maxIndex = 0;
            int max = 0;
            for (int i = 1; i <= n * n; i++) {
                if (max < hashMap.get(i)) {
                    max = hashMap.get(i);
                    maxIndex = i;
                }
            }

            bw.write("#" + Integer.toString(t) + " " + Integer.toString(maxIndex) + " "
                    + Integer.toString(hashMap.get(maxIndex))
                    + "\n");
        }
        bw.flush();
    }

    private static int fun(int value, int y, int x, int count) {
        if (value == n * n) {
            return count;
        }
        for (int dic = 0; dic < 4; dic++) {
            int nx = x + dx[dic];
            int ny = y + dy[dic];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (value + 1 == arr[ny][nx]) {
                return fun(arr[ny][nx], ny, nx, count + 1);
            }
        }
        return count;
    }
}