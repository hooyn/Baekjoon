import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 포도주 시식
 */
public class BJ_2156 {
    static int n;
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        dp = new Integer[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];

        if(n>1){
            dp[2] = arr[1] + arr[2];
        }
        //범위 설정해서 dp값 초기화
        //find()에서 find(n-3)에서 IndexError발생 할 수 있기 때문에 초기화를 해줘야 한다.

        System.out.println(find(n));
    }

    private static int find(int n) {
        if(dp[n] == null){
            dp[n] = Math.max(Math.max(find(n-2),find(n-3)+arr[n-1])+arr[n], find(n-1));
            //n-2번째 중 최고 + arr[n] VS n-3번째 중 최고 + arr[n-1] + arr[n]
            //위에서 최고 값 VS find(n-1) 값 -> 마지막 값을 포함시키지 않아도 되기 때문에 비교하기
        }

        return dp[n];
    }
}
