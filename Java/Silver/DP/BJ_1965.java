package baek0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 상자넣기
 */
public class BJ_1965 {
    static int n;
    static int[] arr;
    static int max = 0;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i] = find(i);
        }

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }

    private static int find(int depth) {
        if(dp[depth] == null){
            dp[depth] = 1;

            for (int i = depth-1; i >= 0; i--) {
                if(arr[depth]>arr[i]){
                    dp[depth] = Math.max(dp[depth], find(i)+1);
                }
            }
        }

        return dp[depth];
    }
}
