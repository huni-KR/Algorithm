package BOJ_16916;

import java.io.*;

public class BOJ_16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String subStr = br.readLine();
        System.out.println(fun(str, subStr) ? 1 : 0);
    }

    private static boolean fun(String str, String subStr) {
        int index = -1;
        for (int i = 0; i <= str.length() - subStr.length(); i++) {
            if (str.charAt(i) == subStr.charAt(0)) {
                for (int j = i + 1; j < i + subStr.length(); j++) {
                    if (str.charAt(j) == subStr.charAt(0) && index == -1) {
                        index = j;
                    }

                    if (str.charAt(j) != subStr.charAt(j - i)) {
                        if (index == -1) {
                            i = j - 1;
                        } else {
                            i = index - 1;
                            index = -1;
                        }
                        break;
                    }
                    if (j - i == subStr.length() - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}