package BOJ_17205;

import java.io.*;

public class BOJ_17205 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] pwd = br.readLine().toCharArray();

        long result = 0;
        for (int i = 0; i < pwd.length; i++) {
            if (i == n - 1) {
                result += pwd[i] - 'a' + 1;
                break;
            }

            long count = 26;
            for (int j = i + 2; j < n; j++)
                count = count * 26 + 26;

            result += (pwd[i] - 'a') * count + (pwd[i] - 'a' + 1);
        }

        System.out.println(result - 1);
    }
}

/*
 * 
 * 12356632 11881376
 * 
 */