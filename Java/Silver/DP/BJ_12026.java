import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 거리
 */
public class BJ_12026 {
    static int pi(String s) {return Integer.parseInt(s);}
    static long[] dp;
    static char[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = pi(br.readLine());

        arr = new char[n];
        arr = br.readLine().toCharArray();

        dp = new long[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n-1; i++) {
            int idx = i;
            char idxBlock = arr[idx];

            if(idxBlock=='B'){
                for (int j = i+1; j < n; j++) {
                    int next = j;
                    char nextBlock = arr[next];
                    if(nextBlock == 'O'){
                        dp[next] = Math.min(dp[next], dp[idx] + (next-idx) * (next-idx));
                    }

                }
            } else if(idxBlock=='O'){
                for (int j = i+1; j < n; j++) {
                    int next = j;
                    char nextBlock = arr[next];
                    if(nextBlock == 'J'){
                        dp[next] = Math.min(dp[next], dp[idx] + (next-idx) * (next-idx));
                    }

                }
            } else {
                for (int j = i+1; j < n; j++) {
                    int next = j;
                    char nextBlock = arr[next];
                    if(nextBlock == 'B'){
                        dp[next] = Math.min(dp[next], dp[idx] + (next-idx) * (next-idx));
                    }
                }
            }
        }
        if(dp[n-1] == Integer.MAX_VALUE){
            System.out.println("-1");
        } else {
            System.out.println(dp[n-1]);
        }
    }
}
