package BOJ_8320;

import java.io.*;
import java.util.HashSet;

class Data {
    int x;
    int y;

    Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        return (x + y);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Data) {
            Data temp = (Data) obj;
            return x == temp.x && y == temp.y;
        } else {
            return false;
        }
    }
}

public class BOJ_8320 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int count = n;
        HashSet set = new HashSet();
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    if (i / j == j) {
                        count++;
                    } else {
                        set.add(new Data(j, i / j));
                        set.add(new Data(i / j, j));
                    }
                }
            }
        }
        System.out.println(count + set.size() / 2);
    }
}