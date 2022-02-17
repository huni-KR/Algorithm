package BOJ_2941;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class BOJ_2941 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        Set<String> set2 = new HashSet<>();
        set2.add("c=");
        set2.add("c-");
        set2.add("d-");
        set2.add("lj");
        set2.add("nj");
        set2.add("s=");
        set2.add("z=");

        Set<String> set3 = new HashSet<>();
        set3.add("dz=");

        int count = 0;
        int s = 0;
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(s, i);
            if (sub.length() == 2) {
                if (set2.contains(sub)) {
                    
                }
            } else if (sub.length() == 3) {

            }
        }
    }
}