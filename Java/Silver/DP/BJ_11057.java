import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 오르막 수
 */
public class BJ_11057 {
    static int n;
    static Long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Long[n+1][10];

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = 1L;
        } //맨 오른쪽 수가 0일 때 오르막 경우의 수는 1이므로 1로 초기화

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }
        //자리수가 1일 때 경우의 수는 1이므로 1로 초기화

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += find(n, i);
            result = result % 10007;
        }

        System.out.println(result);
    }

    private static long find(int digit, int val) {
        if(dp[digit][val]==null){
            dp[digit][val] = 0L;
            //아래에서 합을 구해야하므로 0으로 초기화 시켜준다. 0으로 초기화 시켜주지 않을 시 NullPointerException 발생

            for (int i = val; i >= 0; i--) {
                dp[digit][val] += find(digit-1, i);
                dp[digit][val] = dp[digit][val] % 10007;
            }
        }

        return dp[digit][val];
    }
}
