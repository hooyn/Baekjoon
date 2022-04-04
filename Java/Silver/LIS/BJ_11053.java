import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열
 */
public class BJ_11053 {
    static int n;
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) { //0부터 n-1까지 탐색을 한다.
            LIS(i);
        }

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]); //최대값 구하기
        }
        for (Integer integer : dp) {
            System.out.println(integer);
        }
    }

    private static int LIS(int num) {
        if(dp[num]==null){
            dp[num] = 1;

            for (int i = num - 1; i >= 0; i--) {
                if(arr[i]<arr[num]){
                    dp[num] = Math.max(dp[num], LIS(i) + 1);
                }
            }
        }
        return dp[num];
    }
}

//참고: https://st-lab.tistory.com/137
