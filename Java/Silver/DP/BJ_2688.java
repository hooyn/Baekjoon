import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 줄어들지 않아
 */
public class BJ_2688 {
    static int pi(String s){return Integer.parseInt(s);}
    static long[][] dp = new long[65][10];;
    public static void main(String[] args) throws IOException {
        /**
         * dp[자리수][해당 자리 수] = 경우의 수
         * dp[i][j] = dp[i-1][0]~dp[i-1][9]까지의 합
         */
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j < 10; j++) { //j자리에 들어갈 수
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = pi(br.readLine());
        for (int i = 0; i < testcase; i++) {
            int n = pi(br.readLine());
            long result = 0;
            if(n==1){
                System.out.println(10);
            } else {
                for (int j = 0; j < 10; j++) {
                    result += dp[n][j];
                }
                System.out.println(result);
            }
        }
    }
}
