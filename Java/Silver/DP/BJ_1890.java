import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* 점프
*/
public class BJ_1890 {
    static int pi(String s){return Integer.parseInt(s);}
    static int n;
    static int[][] arr;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = pi(br.readLine());

        arr = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = pi(st.nextToken());
            }
        }

        dp[0][0] = 1L;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==n-1&&j==n-1) break;

                if(dp[i][j]!=0){
                    int plus = arr[i][j];

                    if(i+plus<n){
                        dp[i+plus][j] += dp[i][j];
                    }
                    if(j+plus<n){
                        dp[i][j+plus] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
