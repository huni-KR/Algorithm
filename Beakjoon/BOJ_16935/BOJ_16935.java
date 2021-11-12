package BOJ_16935;

import java.io.*;
import java.util.*;

public class BOJ_16935 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[][] arr = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int calc : list) {
            if (calc == 1) {
                arr = move1(arr, arr.length, arr[0].length);
            } else if (calc == 2) {
                arr = move2(arr, arr.length, arr[0].length);
            } else if (calc == 3) {
                arr = move3(arr, arr.length, arr[0].length);
            } else if (calc == 4) {
                arr = move4(arr, arr.length, arr[0].length);
            } else if (calc == 5) {
                int[][] arr1 = cutArray(arr, 0, arr[0].length / 2, 0, arr.length / 2);
                int[][] arr2 = cutArray(arr, arr[0].length / 2, arr[0].length, 0, arr.length / 2);
                int[][] arr3 = cutArray(arr, 0, arr[0].length / 2, arr.length / 2, arr.length);
                int[][] arr4 = cutArray(arr, arr[0].length / 2, arr[0].length, arr.length / 2, arr.length);
                arr = move5(arr1, arr2, arr3, arr4, arr.length, arr[0].length);
            } else if (calc == 6) {
                int[][] arr1 = cutArray(arr, 0, arr[0].length / 2, 0, arr.length / 2);
                int[][] arr2 = cutArray(arr, arr[0].length / 2, arr[0].length, 0, arr.length / 2);
                int[][] arr3 = cutArray(arr, 0, arr[0].length / 2, arr.length / 2, arr.length);
                int[][] arr4 = cutArray(arr, arr[0].length / 2, arr[0].length, arr.length / 2, arr.length);
                arr = move6(arr1, arr2, arr3, arr4, arr.length, arr[0].length);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(Integer.toString(arr[i][j]));
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] cutArray(int[][] arr, int sx, int ex, int sy, int ey) {
        int[][] tarr = new int[ey - sy][ex - sx];
        for (int i = sy; i < ey; i++) {
            for (int j = sx; j < ex; j++) {
                tarr[i - sy][j - sx] = arr[i][j];
            }
        }
        return tarr;
    }

    private static int[][] move6(int[][] arr1, int[][] arr2, int[][] arr3, int[][] arr4, int y, int x) {
        int[][] tarr = new int[y][x];
        for (int i = 0; i < y / 2; i++) {
            for (int j = 0; j < x / 2; j++) {
                tarr[i][j] = arr2[i][j];
            }
        }
        for (int i = 0; i < y / 2; i++) {
            for (int j = x / 2; j < x; j++) {
                tarr[i][j] = arr4[i][j - x / 2];
            }
        }
        for (int i = y / 2; i < y; i++) {
            for (int j = 0; j < x / 2; j++) {
                tarr[i][j] = arr1[i - y / 2][j];
            }
        }
        for (int i = y / 2; i < y; i++) {
            for (int j = x / 2; j < x; j++) {
                tarr[i][j] = arr3[i - y / 2][j - x / 2];
            }
        }
        return tarr;
    }

    private static int[][] move5(int[][] arr1, int[][] arr2, int[][] arr3, int[][] arr4, int y, int x) {
        int[][] tarr = new int[y][x];
        for (int i = 0; i < y / 2; i++) {
            for (int j = 0; j < x / 2; j++) {
                tarr[i][j] = arr3[i][j];
            }
        }
        for (int i = 0; i < y / 2; i++) {
            for (int j = x / 2; j < x; j++) {
                tarr[i][j] = arr1[i][j - x / 2];
            }
        }
        for (int i = y / 2; i < y; i++) {
            for (int j = 0; j < x / 2; j++) {
                tarr[i][j] = arr4[i - y / 2][j];
            }
        }
        for (int i = y / 2; i < y; i++) {
            for (int j = x / 2; j < x; j++) {
                tarr[i][j] = arr2[i - y / 2][j - x / 2];
            }
        }
        return tarr;
    }

    private static int[][] move4(int[][] arr, int y, int x) {
        int[][] tarr = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tarr[i][j] = arr[j][x - i - 1];
            }
        }
        return tarr;
    }

    private static int[][] move3(int[][] arr, int y, int x) {
        int[][] tarr = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tarr[i][j] = arr[y - j - 1][i];
            }
        }
        return tarr;
    }

    private static int[][] move2(int[][] arr, int y, int x) {
        int[][] tarr = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                tarr[i][j] = arr[i][x - j - 1];
            }
        }
        return tarr;
    }

    private static int[][] move1(int[][] arr, int y, int x) {
        int[][] tarr = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                tarr[i][j] = arr[y - i - 1][j];
            }
        }
        return tarr;
    }
}