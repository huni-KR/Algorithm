package BOJ_17425;

import java.io.*;
import java.util.*;

public class BOJ_17425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int max = arr[arr.length - 1];

        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            list.add(new HashSet<>());
        }

        boolean[] prime = checkPrime(max);

        for (int i = 1; i < list.size(); i++) {
            fun(list, prime[i], i);
        }

        long[] result = new long[max + 1];
        for (int i = 1; i < result.length; i++) {
            for (int t : list.get(i)) {
                result[i] += t;
            }
        }

        long[] dp = new long[max + 1];
        dp[1] = result[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + result[i];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(dp[arr[i]]);
        }
    }

    private static boolean[] checkPrime(int max) {
        boolean[] prime = new boolean[max + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j += i)
                    prime[j] = true;
            }
        }
        return prime;
    }

    private static void fun(ArrayList<HashSet<Integer>> list, boolean prime, int pos) {
        list.get(pos).add(1);
        list.get(pos).add(pos / 1);
        if (prime) {
            return;
        }
        for (int i = 2; i <= pos / 2; i++) {
            if (pos % i == 0) {
                list.get(pos).add(i);
                list.get(pos).add(pos / i);
            }
        }
    }
}