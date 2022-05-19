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
                if(i==n-1&&j==n-1) break; //지점에 도착했을 때

                if(dp[i][j]!=0){ //오른쪽하고 아래로만 점프하기 때문에 차례대로 이동하여 점프를 할 수 있었다면 dp[i][j]는 0보다 클 것이다.
                    int plus = arr[i][j]; //증감값 저장

                    if(i+plus<n){ //범위 내에 위치해 있다면
                        dp[i+plus][j] += dp[i][j]; //dp[i][j](해당 i,j까지의 경우의 수)를 점프한 위치에 더하여 저장한다.
                    }
                    if(j+plus<n){ //범위 내에 위치해 있다면
                        dp[i][j+plus] += dp[i][j]; //dp[i][j](해당 i,j까지의 경우의 수)를 점프한 위치에 더하여 저장한다.
                    }
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
