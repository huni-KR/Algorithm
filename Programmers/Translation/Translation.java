package Translation;

import java.io.*;

public class Translation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(replace(str));
    }

    private static String replace(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                result += '{';
            } else if (str.charAt(i) == ']') {
                result += '}';
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }
}
