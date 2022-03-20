package BOJ_2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int value = arr[0];
        int flag = 0;
        for (int i = 1; i < 8; i++) {
            if (value < arr[i]) {
                value = arr[i];
                if (flag == -1) {
                    flag = 0;
                    break;
                }
                flag = 1;
            } else if (value > arr[i]) {
                value = arr[i];
                if (flag == 1) {
                    flag = 0;
                    break;
                }
                flag = -1;
            }
        }

        if (flag == 1) {
            System.out.println("ascending");
        } else if (flag == -1) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}