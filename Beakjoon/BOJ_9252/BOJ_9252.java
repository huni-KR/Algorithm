package BOJ_9252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9252 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int last;

    static class Data {
        int n;
        String str;

        Data(int n, String str) {
            this.n = n;
            this.str = str;
        }

        public int getN() {
            return n;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        last = 0;
        String result1 = fun(str1, str2);
        last = 0;
        String result2 = fun(str2, str1);
    }

    private static String fun(String str1, String str2) {
        List<Data> list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            String str = check(str1, str2, i, last);
            list.add(new Data(str.length(), str));
        }
        list.sort(Comparator.comparing(Data::getN));
        return list.get(0).str;
    }

    private static String check(String str1, String str2, int i, int j) {
        boolean[] visit = new boolean[str1.length()];
        int tmp = -1;
        while (str2.length() != j) {
            if (str1.charAt(i) == str2.charAt(j)) {
                visit[i] = true;
                i++;
                j++;
                tmp = j;
            } else {
                j++;
            }
        }
        if (tmp != -1) {
            last = tmp;
        }
        return visitToString(str1, visit);
    }

    private static String visitToString(String str, boolean[] visit) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
