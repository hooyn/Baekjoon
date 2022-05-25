import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 격자상의 경로
 */
public class BJ_10164 {
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = pi(st.nextToken());
        int m = pi(st.nextToken());
        int k = pi(st.nextToken());
        long result = 1;

        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        //dp 배열 초기화

        int count = 1;
        //k를 위한 변수 선언
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dp[i][j]==0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                if(count == k){
                    result *= dp[i][j];

                    for (int l = j; l < m; l++) {
                        dp[i][l] = 1;
                    }

                    for (int e = i; e < n; e++) {
                        dp[e][j] = 1;
                    }
                }
                count++;
            }
        }
        System.out.println(result*dp[n-1][m-1]);
    }
}
