package BOJ_17143;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17143 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int R, C, M;
    static List<Shark> list;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { -1, 1, 0, 0 };

    static class Shark {
        int r;
        int c;
        int speed;
        int dic;
        int size;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.speed = s;
            this.dic = d;
            this.size = z;
        }

        public int getR() {
            return r;
        }

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            list.add(new Shark(r, c, s, d, z));
        }

        int sum = 0;
        for (int pos = 1; pos <= C; pos++) {
            sort();
            sum += getShark(pos);
            sharkMove();
            eat();
        }
        System.out.println(sum);
    }

    private static void eat() {
        int[][] arr = new int[R + 1][C + 1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], -1);
        }

        List<Integer> delete = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Shark shark = list.get(i);
            if (arr[shark.r][shark.c] == -1) {
                arr[shark.r][shark.c] = i;
            } else {
                if (list.get(arr[shark.r][shark.c]).size < shark.size) {
                    delete.add(arr[shark.r][shark.c]);
                    arr[shark.r][shark.c] = i;
                } else {
                    delete.add(i);
                }
            }
        }

        delete.sort(Comparator.reverseOrder());
        int deleteSize = delete.size();
        for (int i = 0; i < deleteSize; i++) {
            list.remove((int) delete.get(i));
        }
    }

    private static void sharkMove() {
        for (int i = 0; i < list.size(); i++) {
            Shark shark = list.get(i);
            move(shark);
        }
    }

    private static void move(Shark shark) {
        if (shark.dic < 2) {
            shark.speed %= (R - 1) * 2;
        } else {
            shark.speed %= (C - 1) * 2;
        }

        for (int i = 0; i < shark.speed; i++) {
            shark.c += dx[shark.dic];
            shark.r += dy[shark.dic];

            if (shark.c < 1 || shark.r < 1 || shark.c > C || shark.r > R) {
                if (shark.dic == 0) {
                    shark.dic = 1;
                } else if (shark.dic == 1) {
                    shark.dic = 0;
                } else if (shark.dic == 2) {
                    shark.dic = 3;
                } else {
                    shark.dic = 2;
                }

                shark.c += dx[shark.dic] * 2;
                shark.r += dy[shark.dic] * 2;
            }
        }
    }

    private static int getShark(int pos) {
        for (int i = 0; i < list.size(); i++) {
            Shark shark = list.get(i);
            if (shark.c == pos) {
                int size = shark.size;
                list.remove(i);
                return size;
            }
        }
        return 0;
    }

    private static void sort() {
        list.sort(Comparator.comparing(Shark::getR));
    }
}
// 1. 낚시왕 오른쪽으로 이동 - 맨 오른쪽에 도착하면 종료
// 2. 같은 열에 가장 가까운 상어 잡기
// 3. 상어 이동
// 3-1. 상어 이동시 벽에 막히면 반대편으로 전환해서 이동
// 3-2. 상어 크기가 겹치면 가장 큰 상어가 작은 상어 전부 잡아먹음
// 4. 반복