package BOJ_12981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12981 {

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        a = fun1(a);
        b = fun1(b);
        c = fun1(c);

        if (a == 0 || b == 0 || c == 0) {
            int zeroCounter = fun(a, b, c);

            if (zeroCounter == 2)
                count++;
            else
                count += Math.max(Math.max(a, b), Math.max(c, b));
        } else {
            while (a > 0 && b > 0 && c > 0) {
                a--;
                b--;
                c--;
                count++;
            }
            if (a == 0 || b == 0 || c == 0) {
                count += Math.max(Math.max(a, b), Math.max(b, c));
            }
        }
        System.out.println(count);
    }

    private static int fun1(int num) {
        if (num >= 3) {
            count += num / 3;
            num %= 3;
        }
        return num;
    }

    private static int fun(int a, int b, int c) {
        int count = 0;
        if (a == 0)
            count++;
        if (b == 0)
            count++;
        if (c == 0)
            count++;
        return count;
    }
}
