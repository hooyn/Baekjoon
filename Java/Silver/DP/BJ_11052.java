import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카드 구매하기
 */
public class BJ_11052 {
    static int n;
    static int[] P;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        P = new int[n+1];
        dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        } //P배열 초기화

        find();

        System.out.println(dp[n]);
    }

    private static void find() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //System.out.println(i + ": " + dp[i] + " : " + (dp[i-j] + P[j]));
                dp[i] = Math.max(dp[i], dp[i-j] + P[j]);
            }
        }
    }
}
