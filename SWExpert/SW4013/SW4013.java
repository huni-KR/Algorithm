package SW4013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW4013 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, K, max;
    static int[] turn;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            K = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                list.add(new ArrayList<>());
            }
            // N==0 / S==1
            // S일때 점수 획득
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 8; j++) {
                    list.get(i).add(Integer.parseInt(st.nextToken()));
                }
            }

            // num에서의 2/6번 확인
            // num옆에 있는 바퀴 6/2번 확인
            // 조건 만족하면 way 반대로 해서 넘기기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int num = Integer.parseInt(st.nextToken()) - 1;
                int way = Integer.parseInt(st.nextToken()); // 시계 1 / 반시계 -1

                turn = new int[4];
                turn[num] = way;
                fun(num, way, 1);
                fun(num, way, -1);
                move();
            }

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Integer.toString(getSum()));
            bw.write("\n");
        }
        bw.flush();
    }

    private static void move() {
        for (int i = 0; i < 4; i++) {
            if (turn[i] == 1) {
                int last = list.get(i).get(list.get(i).size() - 1);
                list.get(i).remove(list.get(i).size() - 1);
                list.get(i).add(0, last);
            } else if (turn[i] == -1) {
                int first = list.get(i).get(0);
                list.get(i).remove(0);
                list.get(i).add(first);
            }
        }
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (list.get(i).get(0) == 1) {
                sum += Math.pow(2, i);
            }
        }
        return sum;
    }

    private static void fun(int num, int way, int index) {
        if ((index == 1 && num == 3) || (index == -1 && num == 0)) {
            return;
        }

        if (index == 1 && list.get(num).get(2) != list.get(num + 1).get(6)) {
            turn[num + 1] = way * -1;
            fun(num + 1, way * -1, 1);
        }

        if (index == -1 && list.get(num).get(6) != list.get(num - 1).get(2)) {
            turn[num - 1] = way * -1;
            fun(num - 1, way * -1, -1);
        }
    }
}