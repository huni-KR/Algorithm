package BOJ_5549;

import java.io.*;
import java.util.StringTokenizer;

class Data {
    int j;
    int o;
    int i;

    Data(int j, int o, int i) {
        this.j = j;
        this.o = o;
        this.i = i;
    }
}

public class BOJ_5549 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        char[][] area = new char[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                area[i][j] = str.charAt(j);
            }
        }

        Data[][] data = new Data[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0 && j == 0) {
                    if (area[i][j] == 'J') {
                        data[i][j] = new Data(1, 0, 0);
                    } else if (area[i][j] == 'O') {
                        data[i][j] = new Data(0, 1, 0);
                    } else if (area[i][j] == 'I') {
                        data[i][j] = new Data(0, 0, 1);
                    }
                } else if (i == 0) {
                    if (area[i][j] == 'J') {
                        data[i][j] = new Data(data[i][j - 1].j + 1, data[i][j - 1].o, data[i][j - 1].i);
                    } else if (area[i][j] == 'O') {
                        data[i][j] = new Data(data[i][j - 1].j, data[i][j - 1].o + 1, data[i][j - 1].i);
                    } else if (area[i][j] == 'I') {
                        data[i][j] = new Data(data[i][j - 1].j, data[i][j - 1].o, data[i][j - 1].i + 1);
                    }
                } else if (j == 0) {
                    if (area[i][j] == 'J') {
                        data[i][j] = new Data(data[i - 1][j].j + 1, data[i - 1][j].o, data[i - 1][j].i);
                    } else if (area[i][j] == 'O') {
                        data[i][j] = new Data(data[i - 1][j].j, data[i - 1][j].o + 1, data[i - 1][j].i);
                    } else if (area[i][j] == 'I') {
                        data[i][j] = new Data(data[i - 1][j].j, data[i - 1][j].o, data[i - 1][j].i + 1);
                    }
                } else {
                    if (area[i][j] == 'J') {
                        data[i][j] = new Data(data[i - 1][j].j + data[i][j - 1].j - data[i - 1][j - 1].j + 1,
                                data[i - 1][j].o + data[i][j - 1].o - data[i - 1][j - 1].o,
                                data[i - 1][j].i + data[i][j - 1].i - data[i - 1][j - 1].i);
                    } else if (area[i][j] == 'O') {
                        data[i][j] = new Data(data[i - 1][j].j + data[i][j - 1].j - data[i - 1][j - 1].j,
                                data[i - 1][j].o + data[i][j - 1].o - data[i - 1][j - 1].o + 1,
                                data[i - 1][j].i + data[i][j - 1].i - data[i - 1][j - 1].i);
                    } else if (area[i][j] == 'I') {
                        data[i][j] = new Data(data[i - 1][j].j + data[i][j - 1].j - data[i - 1][j - 1].j,
                                data[i - 1][j].o + data[i][j - 1].o - data[i - 1][j - 1].o,
                                data[i - 1][j].i + data[i][j - 1].i - data[i - 1][j - 1].i + 1);
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;

            if (startX == 0 && startY == 0) {
                bw.write(Integer.toString(data[endY][endX].j) + " " + Integer.toString(data[endY][endX].o) + " "
                        + Integer.toString(data[endY][endX].i) + "\n");
            } else if (startY == 0) {
                bw.write(Integer.toString(data[endY][endX].j - data[endY][startX - 1].j) + " "
                        + Integer.toString(data[endY][endX].o - data[endY][startX - 1].o) + " "
                        + Integer.toString(data[endY][endX].i - data[endY][startX - 1].i) + "\n");
            } else if (startX == 0) {
                bw.write(Integer.toString(data[endY][endX].j - data[startY - 1][endX].j) + " "
                        + Integer.toString(data[endY][endX].o - data[startY - 1][endX].o) + " "
                        + Integer.toString(data[endY][endX].i - data[startY - 1][endX].i) + "\n");
            } else {
                bw.write(Integer
                        .toString(data[endY][endX].j + data[startY - 1][startX - 1].j - data[startY - 1][endX].j
                                - data[endY][startX - 1].j)
                        + " "
                        + Integer.toString(data[endY][endX].o + data[startY - 1][startX - 1].o
                                - data[startY - 1][endX].o - data[endY][startX - 1].o)
                        + " " + Integer.toString(data[endY][endX].i + data[startY - 1][startX - 1].i
                                - data[startY - 1][endX].i - data[endY][startX - 1].i)
                        + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
