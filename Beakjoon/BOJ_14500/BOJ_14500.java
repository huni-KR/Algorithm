package BOJ_14500;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14500 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int x, y;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        arr = new int[y + 8][x + 8];
        for (int i = 4; i < y + 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 4; j < x + 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] do1 = new boolean[4][4];
        for (int i = 0; i < do1.length; i++) {
            do1[i][0] = true;
        }
        boolean[][] do2 = { { true, true }, { true, true } };
        boolean[][] do3 = { { true, false, false }, { true, false, false }, { true, true, false } };
        boolean[][] do4 = { { true, false, false }, { true, true, false }, { false, true, false } };
        boolean[][] do5 = { { false, false, false }, { true, true, true }, { false, true, false } };

        int max = 0;
        max = Math.max(search(do1), max);
        max = Math.max(search(do2), max);
        max = Math.max(search(do3), max);
        max = Math.max(search(do4), max);
        max = Math.max(search(do5), max);
        System.out.println(max);
    }

    private static int search(boolean[][] domino) {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            max = Math.max(find(domino), max);
            domino = mirror1(domino);
            max = Math.max(find(domino), max);
            domino = mirror1(domino);

            domino = mirror2(domino);
            max = Math.max(find(domino), max);
            domino = mirror2(domino);
            domino = spin(domino);
        }
        return max;
    }

    private static boolean[][] mirror2(boolean[][] domino) {
        int size = domino.length;
        boolean[][] newDomino = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newDomino[i][j] = domino[i][size - j - 1];
            }
        }
        return newDomino;
    }

    private static boolean[][] mirror1(boolean[][] domino) {
        int size = domino.length;
        boolean[][] newDomino = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newDomino[i][j] = domino[size - i - 1][j];
            }
        }
        return newDomino;
    }

    private static int find(boolean[][] domino) {
        int max = 0;
        for (int i = 0; i <= arr.length - domino.length; i++) {
            for (int j = 0; j <= arr[0].length - domino[0].length; j++) {
                int tmp = 0;
                for (int i1 = i; i1 < i + domino.length; i1++) {
                    for (int j1 = j; j1 < j + domino[0].length; j1++) {
                        if (domino[i1 - i][j1 - j]) {
                            tmp += arr[i1][j1];
                        }
                    }
                }

                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    private static boolean[][] spin(boolean[][] domino) {
        int size = domino.length;
        boolean[][] newDomino = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newDomino[i][j] = domino[size - j - 1][i];
            }
        }
        return newDomino;
    }
}
