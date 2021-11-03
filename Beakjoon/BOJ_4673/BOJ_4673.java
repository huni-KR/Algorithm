package BOJ_4673;

import java.util.*;

public class BOJ_4673 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i < 10000; i++) {
            String str = Integer.toString(i);
            int value = i;
            for (int j = 0; j < str.length(); j++) {
                value += str.charAt(j) - '0';
            }
            set.add(value);
        }

        for (int i = 1; i < 10000; i++) {
            if (!set.contains(i)) {
                sb.append(Integer.toString(i));
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
