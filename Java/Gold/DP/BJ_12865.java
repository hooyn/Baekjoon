import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 평범한 배낭
 */
public class BJ_12865 {
    static Integer[][] dp;
    static int[] w;
    static int[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        w = new int[n];
        v = new int[n];

        dp = new Integer[n][k+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(n-1, k));
    }

    private static int knapsack(int i, int k) {
        //범위 밖이라면
        if(i<0) return 0;

        if(dp[i][k] == null){
            //현재 물건을 추가로 담지 못하는 경우 [이전 탐색]
            if(w[i] > k){
                dp[i][k] = knapsack(i-1, k);
            }

            //현재 물건을 담을 수 있다면
            else{
                dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-w[i]) + v[i]);
            }
        }
        return dp[i][k];
    }
}
