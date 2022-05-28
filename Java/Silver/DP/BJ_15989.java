import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3 더하기 4
 */
public class BJ_15989 {
	static int pi(String s) {return Integer.parseInt(s);}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = pi(br.readLine());
		int[][] dp = new int[10001][4];
		dp[1][1] = 1; // 1 -> 1을 만드는 경우의 수 중에 1로 끝나는 것
		dp[2][1] = 1; // 1+1 -> 2를 만드는 경우의 수 중 1로 끝나는 것
		dp[2][2] = 1; // 2 -> 2를 만드는 경우의 수 중 2로 끝나는 것
		dp[3][1] = 1; // 1+1+1 -> 3를 만드는 경우의 수 중 1로 끝나는 것
		dp[3][2] = 1; // 1+2 -> 3를 만드는 경우의 수 중 2로 끝나는 것
		dp[3][3] = 1; // 3 -> 3를 만드는 경우의 수 중 3로 끝나는 것
		
		for(int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i-1][1]; 
			// 4를 만든다고 할 때 3을 만드는 수식에서 1을 더하는 것
			
			dp[i][2] = dp[i-2][1] + dp[i-2][2]; 
			// 4를 만든다고 할 때 2를 만드는 수식에서 1로 끝나는 것과, 2로 끝나는 것에 2를 더하는 것
			
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
			// 4를 만든다고 할 때 1을 만드는 수식에서 1로 끝나는 것, 2로 끝나는 것, 3으로 끝나는 것에 3을 더하는 것
		}
		
		for(int i = 0; i < n; i++) {
			int num = pi(br.readLine());
			System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
			// num을 만드는 경우의 수 중에 1로 끝나는 것 2로 끝나는 것 3으로 끝나는 것을 더한 경우의 수
		}
	}
}
