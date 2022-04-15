import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 정수 삼각형
 */
public class BJ_1932 {
    static int n;
    static int[][] arr;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n-1][i] = arr[n-1][i];
        }

        System.out.println(find(0,0));
    }

    private static int find(int row, int col) {
        if(row==n-1){
            return dp[row][col];
        }

        if(dp[row][col] == null){
            dp[row][col] = Math.max(find(row+1, col), find(row+1, col+1)) + arr[row][col];
        }

        return dp[row][col];
    }
}
