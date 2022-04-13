package SW9760;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW9760 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T;
    static int[] shapeCount, valueCount;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            shapeCount = new int[4];
            valueCount = new int[13];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 5; i++) {
                String str = st.nextToken();
                int shape = getShape(str.charAt(0));
                int value = getValue(str.charAt(1)) - 1;

                shapeCount[shape]++;
                valueCount[value]++;
            }

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(fun());
            bw.write("\n");
        }
        bw.flush();
    }

    private static String fun() {
        if (checkStraight() && checkFlush()) {
            return "Straight Flush";
        } else if (checkCount(4, 1)) {
            return "Four of a Kind";
        } else if (checkCount(3, 1) && checkCount(2, 1)) {
            return "Full House";
        } else if (checkFlush()) {
            return "Flush";
        } else if (checkStraight()) {
            return "Straight";
        } else if (checkCount(3, 1)) {
            return "Three of a kind";
        } else if (checkCount(2, 2)) {
            return "Two pair";
        } else if (checkCount(2, 1)) {
            return "One pair";
        } else {
            return "High card";
        }
    }

    private static boolean checkCount(int index, int pair) {
        int count = 0;
        for (int i = 0; i < valueCount.length; i++) {
            if (valueCount[i] == index) {
                count++;
            }
        }
        return count == pair ? true : false;
    }

    private static boolean checkFlush() {
        for (int i = 0; i < shapeCount.length; i++) {
            if (shapeCount[i] == 5) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkStraight() {
        for (int i = 0; i < valueCount.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (valueCount[(i + j) % 13] == 1) {
                    if (j == 4) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    private static int getShape(char c) {
        if (c == 'S') {
            return 0;
        } else if (c == 'D') {
            return 1;
        } else if (c == 'H') {
            return 2;
        } else {
            return 3;
        }
    }

    private static int getValue(char c) {
        if (c == 'A') {
            return 1;
        } else if (c == 'T') {
            return 10;
        } else if (c == 'J') {
            return 11;
        } else if (c == 'Q') {
            return 12;
        } else if (c == 'K') {
            return 13;
        } else {
            return c - '0';
        }
    }
}