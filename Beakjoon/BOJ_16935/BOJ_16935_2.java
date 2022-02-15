package BOJ_16935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16935_2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n, m, r;
    static int[] dx, dy;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        dx = new int[] { 0, 1, 0, -1 };
        dy = new int[] { 1, 0, -1, 0 };

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] command = new int[r];
        for (int i = 0; i < r; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            switch (command[i]) {
                case 1:
                    arr = upDown(arr);
                    break;
                case 2:
                    arr = leftRight(arr);
                    break;
                case 3:
                    arr = toRight(arr);
                    break;
                case 4:
                    arr = toLeft(arr);
                    break;
                case 5:
                    arr = divideRight(arr);
                    break;
                case 6:
                    arr = divideLeft(arr);
                    break;
                default:
                    break;
            }
        }
        printArray(arr);
    }

    private static int[][] divideLeft(int[][] arr) {
        int nx = arr[0].length, ny = arr.length;
        int[][] tmp = new int[ny][nx];
        int sizeX = nx / 2, sizeY = ny / 2;

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                tmp[i][j] = arr[i][j + sizeX];
            }
        }

        for (int i = sizeY; i < ny; i++) {
            for (int j = 0; j < sizeX; j++) {
                tmp[i][j] = arr[i - sizeY][j];
            }
        }

        for (int i = sizeY; i < ny; i++) {
            for (int j = sizeX; j < nx; j++) {
                tmp[i][j] = arr[i][j - sizeX];
            }
        }

        for (int i = 0; i < sizeY; i++) {
            for (int j = sizeX; j < nx; j++) {
                tmp[i][j] = arr[i + sizeY][j];
            }
        }

        return tmp;
    }

    private static int[][] divideRight(int[][] arr) {
        int nx = arr[0].length, ny = arr.length;
        int[][] tmp = new int[ny][nx];
        int sizeX = nx / 2, sizeY = ny / 2;

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                tmp[i][j] = arr[i + sizeY][j];
            }
        }

        for (int i = sizeY; i < ny; i++) {
            for (int j = 0; j < sizeX; j++) {
                tmp[i][j] = arr[i][j + sizeX];
            }
        }

        for (int i = sizeY; i < ny; i++) {
            for (int j = sizeX; j < nx; j++) {
                tmp[i][j] = arr[i - sizeY][j];
            }
        }

        for (int i = 0; i < sizeY; i++) {
            for (int j = sizeX; j < nx; j++) {
                tmp[i][j] = arr[i][j - sizeX];
            }
        }

        return tmp;
    }

    private static int[][] toLeft(int[][] arr) {
        int nx = arr[0].length, ny = arr.length;
        int[][] tmp = new int[nx][ny];
        for (int i = 0; i < ny; i++) {
            for (int j = 0; j < nx; j++) {
                tmp[nx - j - 1][i] = arr[i][j];
            }
        }
        return tmp;
    }

    private static int[][] toRight(int[][] arr) {
        int nx = arr[0].length, ny = arr.length;
        int[][] tmp = new int[nx][ny];
        for (int i = 0; i < ny; i++) {
            for (int j = 0; j < nx; j++) {
                tmp[j][ny - i - 1] = arr[i][j];
            }
        }
        return tmp;
    }

    private static int[][] leftRight(int[][] arr) {
        int nx = arr[0].length, ny = arr.length;
        int[][] tmp = new int[ny][nx];
        for (int i = 0; i < ny; i++) {
            for (int j = 0; j < nx; j++) {
                tmp[i][j] = arr[i][nx - j - 1];
            }
        }
        return tmp;
    }

    private static int[][] upDown(int[][] arr) {
        int nx = arr[0].length, ny = arr.length;
        int[][] tmp = new int[ny][nx];
        for (int i = 0; i < ny; i++) {
            for (int j = 0; j < nx; j++) {
                tmp[i][j] = arr[ny - i - 1][j];
            }
        }
        return tmp;
    }

    private static void printArray(int[][] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                bw.write(Integer.toString(arr[i][j]) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

}