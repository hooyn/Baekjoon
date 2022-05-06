import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동전
 */
public class BJ_2293 {
    static int n;
    static int m;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[m+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                dp[j] = dp[j] + dp[j - arr[i]];
                //dp[j-arr[i]] -> 현재 동전을 사용하고 남은 금액을 만들 수 있는지.
                //이전에 접근을 했다면 100001이 아닐 것이기 때문에 그 값에 +1을 해준다.
                //만약 반복문이 끝나고 100001인 값이 있다면 한번도 접근하지 않은 값이기 때문에
                //만들 수 없는 값임을 알 수 있다.
            }
        }

        System.out.println(dp[m]);
    }
}
