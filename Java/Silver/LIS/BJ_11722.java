package jpabook.baekjoon.baek0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 감소하는 부분 수열
 */
public class BJ_11722 {
    static int n;
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new Integer[n];

        dp[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            LIS(i);
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

    private static int LIS(int x) {
        if(dp[x]==null){
            dp[x] = 1;

            for (int i = x-1; i >= 0; i--) {
               if(arr[i] > arr[x]){
                   dp[x] = Math.max(dp[x], LIS(i) + 1);
               }
            }
        }

        return dp[x];
    }
}
