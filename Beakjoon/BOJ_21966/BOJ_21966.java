package BOJ_21966;

import java.io.*;
import java.util.*;

public class BOJ_21966 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                list.add(i);
            }
        }

    }
}