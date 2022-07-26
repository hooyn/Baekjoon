import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 합분해 골드 5
 */
public class BJ_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[201][201];

        //배열 초기화
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1;
        }

        //bottom-up
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1_000_000_000;
            }
        }

        System.out.println(dp[k][n]);
    }
}

//참고: https://hu-coding.tistory.com/28
