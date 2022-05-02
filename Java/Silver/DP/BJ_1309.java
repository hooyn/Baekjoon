import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 동물원
 */
public class BJ_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 9901;
        int n = Integer.parseInt(br.readLine());

        // dp[i][j] : i번째 줄의 j번째 칸에 동물을 놓을 수 있는 경우의 수
        // j = 0 : 아무 동물도 놓지 않음
        // j = 1 : 첫 번째 칸에 동물을 놓음
        // j = 2 : 두 번째 칸에 동물을 놓음
        long[][] dp = new long[n+1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        long result = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;
        System.out.println(result);
    }
}

//참고: https://steady-coding.tistory.com/156
