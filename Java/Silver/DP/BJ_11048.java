import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이동하기
 */
public class BJ_11048 {
    static int n;
    static int m;
    static int[][] arr;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new Integer[n+1][m+1];
        for (int i = 0; i <= m; i++) { //dp 배열 첫번째 row 초기화
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) { //dp 배열 첫번째 col 초기화
            dp[n][0] = 0;
        }

        arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) { //arr 배열 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(find(n, m));
    }

    private static int find(int row, int col) {
        if(dp[row][col]==null){
            dp[row][col] = 0;

            int[] d_row = {-1, -1, 0};
            int[] d_col = {0, -1, -1};

            for (int i = 0; i < 3; i++) {
                int n_row = row + d_row[i];
                int n_col = col + d_col[i];

                //범위 내에 있다면
                if(n_row>=0&&n_row<=n&&n_col>=0&&n_col<=m){
                    dp[row][col] = Math.max(dp[row][col], find(n_row, n_col)+arr[row][col]);
                }
            }
        }

        return dp[row][col];
    }
}
