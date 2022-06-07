import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LCS
 */
public class BJ_9251_topDown {
    static char[] firstStr;
    static char[] secondStr;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        firstStr = br.readLine().toCharArray();
        secondStr = br.readLine().toCharArray();

        dp = new Integer[firstStr.length][secondStr.length];

        System.out.println(LCS(firstStr.length-1, secondStr.length-1));
    }

    private static int LCS(int first, int second) {
        //인덱스 범위 밖일 경우. (공집합)
        if(first==-1 || second==-1){
            return 0;
        }

        if(dp[first][second] == null){
            if(firstStr[first] == secondStr[second]){
                dp[first][second] = LCS(first-1, second-1) + 1;
            } else{
                dp[first][second] = Math.max(LCS(first-1,second), LCS(first, second-1));
            }
        }
        return dp[first][second];
    }
}
