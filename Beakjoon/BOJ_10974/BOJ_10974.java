package BOJ_10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10974 {

    static int n;
    static int[] arr;
    static boolean[] visit;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        visit = new boolean[n + 1];

        list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(fun(n, i, new StringBuilder()));
        }
    }

    private static String fun(int size, int now, StringBuilder sb) {
        if (isFull()) {
            return sb.toString();
        }
        return null;
    }

    private static boolean isFull() {
        for (int i = 1; i < visit.length; i++) {
            if (!visit[i]) {
                return false;
            }
        }
        return true;
    }
}