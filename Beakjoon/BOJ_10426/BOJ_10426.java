package BOJ_10426;

import java.io.*;
import java.util.*;

public class BOJ_10426 {

    static boolean[] leapYear = new boolean[300];
    static int[][] months = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "- ");

        int sYear = Integer.parseInt(st.nextToken()) - 1900;
        int sMonth = Integer.parseInt(st.nextToken()) - 1;
        int sDay = Integer.parseInt(st.nextToken());
        int days = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 1900; i < 2100; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                leapYear[i - 1900] = true;
            }
        }

        while (days != 0) {
            
            sDay++;
            days--;

            if (!leapYear[sYear]) {
                if (sDay > months[0][sMonth]) {
                    sMonth++;
                    sDay = 1;
                }
                if (sMonth == 12) {
                    sYear++;
                    sMonth = 0;
                    sDay = 1;
                }
            } else {
                if (sDay > months[1][sMonth]) {
                    sMonth++;
                    sDay = 1;
                }
                if (sMonth == 12) {
                    sYear++;
                    sMonth = 0;
                    sDay = 1;
                }
            }

        }
        sYear += 1900;
        sMonth++;

        String resultYear = fun(sYear);
        String resultMonth = fun(sMonth);
        String resultDay = fun(sDay);

        System.out.println(resultYear + "-" + resultMonth + "-" + resultDay);
    }

    private static String fun(int i) {
        if (i < 10) {
            return 0 + Integer.toString(i);
        }
        return Integer.toString(i);
    }
}
