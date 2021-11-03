package BOJ_1110;

import java.io.*;

public class BOJ_1110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int origin = Integer.parseInt(br.readLine());
        int tmp1 = origin, tmp2 = 0;
        int count = 0;

        while (true) {
            count++;
            int ten = tmp1 / 10;
            int one = tmp1 % 10;

            tmp2 = one * 10 + (one + ten) % 10;

            if (origin == tmp2) {
                break;
            }
            tmp1 = tmp2;
        }
        System.out.println(count);
    }
}

/*
 * 26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운
 * 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다. 위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는
 * 4이다.
 */