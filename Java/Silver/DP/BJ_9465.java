import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스티커
 */
public class BJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n+1][2];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n+1][2];
            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];

            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];

            if(n<2){ //n==1 이면 그냥 둘중에 높은 카드 점수 출력
                System.out.println(Math.max(dp[1][0], dp[1][1]));
            } else {
                for (int j = 2; j <= n; j++) {
                    dp[j][0] = Math.max(dp[j-1][1], dp[j-2][1]) + arr[j][0];
                    dp[j][1] = Math.max(dp[j-1][0], dp[j-2][0]) + arr[j][1];
                }

                System.out.println(Math.max(dp[n][0], dp[n][1]));
            }
        }
    }
}
