import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 돌 게임 3
 */
public class BJ_9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /**
         * n이 0 이라면 상근이가 가져갈 수 있는 돌이 없으므로 Lose
         * n이 1 이라면 상근이가 1개 가져가고 창영이가 가져갈 수 있는 돌이 없으므로 Win
         * n이 2 라면 상근이가 1개 가져가고 창영이가 1개 가져가면 상근이가 가져갈 수 있는 돌이 없으므로 Lose
         * n이 3 이라면 상근이가 3개 가져갔을 때 Win / 상근이가 1개, 창여이가 1개, 상근이가 1개 가져가면 Win
         * n이 4 라면 상근이가 1개, 창영 1개, 상근 1개 창영 1개 Lose, 상근이가 3개 창영이가 1개 Lose 상근 4개 Win
         * n이 5 라면 상근이 3개 창영 1개 상근 1개 Win/ 상근 1개, 창, 상, 창, 상 Win
         * n이 6 이라면 상근 1개 dp[5]=win / 상근 3개 dp[3]=lose / 상근 4개 dp[1]=win
         *
         * 창영이가 하나라도 지는 경우의 수가 있으면 상근 win
         */

        System.out.println((n % 7 == 0 || n % 7 == 2) ? "CY" : "SK");
    }
}
