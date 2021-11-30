package BOJ_1769;

import java.io.*;

public class BOJ_1769 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = fun(str);
        System.out.println(count);
        System.out.println(check(str) ? "YES" : "NO");
    }

    private static String fun(String str) {
        if (str.length() > 1) {
            count++;
            str = Integer.toString(StringToInteger(str));
            return fun(str);
        }
        return str;
    }

    private static int StringToInteger(String str) {
        int value = 0;
        for (int i = 0; i < str.length(); i++) 
            value += str.charAt(i) - '0';
        return value;
    }

    private static boolean check(String str) {
        int value = Integer.parseInt(str);
        return value % 3 == 0 ? true : false;
    }
}