import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기
 */
public class BJ_1463 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {

            //반복문을 사용해서 경우의 수를 N개만 고려한다.
            dp[i] = dp[i-1] + 1;
            if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            //dp를 반복문을 돌면서 제일 작은 수를 고려한다.
        }
        System.out.println(dp[n]);
    }
}
