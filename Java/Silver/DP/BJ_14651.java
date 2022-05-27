import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 걷다보니 신천역 삼 (Large)
 */
public class BJ_14651 {
    public static final int MOD = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] d = new long[33334];
        //d[i] = 0,1,2로 만든 i자리 3의 배수의 개수
        d[1] = 0;
        d[2] = 2;
        // => 12, 21
        d[3] = 6;
        // => 102, 111, 120, 201, 210, 222
        d[4] = 18;
        // => 1002, 1020, 1200, 2220, 2202, 2022, 1110, 1101, 1011,
        // => 2211, 2112, 2211, 1212, 2121, 2100, 2010, 2001, 1122

        for (int i = 5; i <= n; i++) {
            d[i] = (d[i-1]*3) % MOD;
        }

        System.out.println(d[n]);
    }
}
