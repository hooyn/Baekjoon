import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쉬운 계단 수
 */
public class BJ_10844 {
    static int n;
    static long result = 0;
    static Long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Long[n+1][10];

        for (int i = 0; i < 10; i++) {
             dp[1][i] = 1L;
        }

        for (int i = 1; i < 10; i++) {
            result += find(n, i);
        }

        System.out.println(result % 1000000000);
    }

    private static long find(int digit, int val) {
        if(digit==1){
            return dp[digit][val];
        }

        if(dp[digit][val] == null){
            if(val == 0){
                dp[digit][val] = find(digit-1, 1);
            } //val가 0일 경우 1밖에 들어올 수 없다.
            else if(val == 9){
                dp[digit][val] = find(digit-1, 8);
            } //val가 9일 경우 다음은 8밖에 올 수 없다.
            else{
                dp[digit][val] = find(digit-1, val-1) + find(digit-1, val+1);
            }
        }
        
        return dp[digit][val] % 1000000000;
    }
}
