import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RGB거리
 */
public class BJ_1149 {
    static int n;
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1][3];
        dp = new int[n+1][3];

        for (int i = 1; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][0] = arr[1][0]; //빨간색으로 시작하는 경우의 첫번째 값 저장
        dp[1][1] = arr[1][1]; //초록색으로 시작하는 경우의 첫번째 값 저장
        dp[1][2] = arr[1][2]; //파란색으로 시작하는 경우의 첫번째 값 저장

        System.out.println(Math.min(find(n, 0),Math.min(find(n, 1), find(n, 2))));
        //빨간색, 초록색, 파란색으로 끝나는 경우의 수 중에서 가장 작은 값 리턴
    }

    private static int find(int depth, int color) {
        if(dp[depth][color]==0){
            if(color==0){ //빨간색으로 끝나는 경우
                dp[depth][0] = Math.min(find(depth-1, 1), find(depth-1, 2)) + arr[depth][0];
            } else if(color==1){ //초록색으로 끝나는 경우
                dp[depth][1] = Math.min(find(depth-1, 0), find(depth-1, 2)) + arr[depth][1];
            } else if(color==2){ //파란색으로 끝나는 경우
                dp[depth][2] = Math.min(find(depth-1, 0), find(depth-1, 1)) + arr[depth][2];
            }
        }

        return dp[depth][color];
    }
}
