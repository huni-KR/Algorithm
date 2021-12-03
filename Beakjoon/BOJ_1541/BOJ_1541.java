package BOJ_1541;

import java.io.*;
import java.util.*;

public class BOJ_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(str, "-");
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }

        int min = stringToInteger(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            min -= stringToInteger(list.get(i));
        }

        System.out.println(min);
    }

    private static int stringToInteger(String str) {
        StringTokenizer st = new StringTokenizer(str, "+");
        int result = 0;
        while (st.hasMoreTokens()) {
            result += Integer.parseInt(st.nextToken());
        }
        return result;
    }
}
