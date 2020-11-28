package BOJ_5675;

import java.io.*;

public class BOJ_5675 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str) % 6;
            if (n == 0)
                bw.write("Y\n");
            else
                bw.write("N\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
