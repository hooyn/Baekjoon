import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 타일 채우기
 */
public class BJ_2133 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int result = 0;
        int[] dp = new int[n+1];

        // n이 홀수라면 모든 면을 2*1 1*2 타일로 채울 수 없다.
        if(n % 2 == 1){
            result = 0;
        } else {
            dp[0] = 1;
            dp[2] = 3;
            for (int i = 4; i <= n; i += 2) {
                dp[i] = dp[i-2] * dp[2];
                for (int j = i-4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }

            result = dp[n];
        }

        System.out.println(dp[n]);
    }
}

/**
 *  * 이 문제의 점화식
 *  * F[N] = ( F[N - 2] * F[2] ) + ( F[N - 4] * 2 ) + ( F[N - 6] * 2) + ( F[N - 8] * 2 ) + ... + ( F[0] * 2 )
 *  * 출처: https://yabmoons.tistory.com/536 [얍문's Coding World..:티스토리]
 */
