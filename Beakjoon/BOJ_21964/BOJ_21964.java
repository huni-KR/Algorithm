package BOJ_21964;

import java.io.*;
import java.util.*;

public class BOJ_21964 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(str.substring(str.length() - 5));
    }
}
