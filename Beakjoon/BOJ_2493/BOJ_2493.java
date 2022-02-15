package BOJ_2493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;

    static class Data {
        int index;
        int value;

        Data(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Data[] datas = new Data[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            datas[i] = new Data(i, Integer.parseInt(st.nextToken()));
        }

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] result = new int[n + 1];
        fun(datas, result);
        write(result);
        bw.flush();
    }

    private static void write(int[] result) throws IOException {
        for (int i = 1; i < result.length; i++) {
            bw.write(Integer.toString(result[i]) + " ");
        }
    }

    private static void fun(Data[] datas, int[] result) {
        Stack<Data> stack = new Stack<>();

        for (int i = n; i >= 1; i--) {
            Data data = datas[i];
            if (stack.isEmpty()) {
                stack.push(data);
                continue;
            }

            if (data.value > stack.peek().value) {
                while (!stack.isEmpty()) {
                    if (data.value < stack.peek().value) {
                        break;
                    }
                    Data pop = stack.pop();
                    result[pop.index] = data.index;
                }
            }
            stack.add(data);
        }

        while (!stack.isEmpty()) {
            Data pop = stack.pop();
            result[pop.index] = 0;
        }
    }
}
