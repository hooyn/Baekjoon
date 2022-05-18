import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 퇴사 2
 */
public class BJ_15486 {
    static int pi(String s){return Integer.parseInt(s);}
    static int n;
    static int[] T;
    static int[] P;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = pi(br.readLine());

        T = new int[n+2];
        P = new int[n+2];
        dp = new int[n+2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = pi(st.nextToken());
            P[i] = pi(st.nextToken());
        }

        int max = -1; //각 Day마다 Max값 저장
        for (int i = 1; i < n+2; i++) {
            if(max<dp[i]){
                max = dp[i];
            }

            int nxt = i + T[i];
            if(nxt < n+2){ //이동한 후에 dp값이 최고 값이 되도록 dp[nxt] 저장
                dp[nxt] = Math.max(dp[nxt], max+P[i]);
            }
        }

        System.out.println(dp[n+1]);
    }
}
