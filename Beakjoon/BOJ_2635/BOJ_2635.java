package BOJ_2635;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2635 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<List<Integer>> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            list.get(i).add(n);
            list.get(i).add(i);

            int pos = 1;
            while (true) {
                int value = list.get(i).get(pos - 1) - list.get(i).get(pos);
                if (value < 0) {
                    break;
                }
                list.get(i).add(value);
                pos++;
            }
        }

        int index = findIndex(list);

        System.out.println(list.get(index).size());
        for (int i : list.get(index)) {
            System.out.print(i + " ");
        }
    }

    private static int findIndex(List<List<Integer>> list) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i).size()) {
                max = list.get(i).size();
                index = i;
            }
        }
        return index;
    }
}