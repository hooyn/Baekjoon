import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 조합
 */
public class BJ_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger bigInteger1 = BigInteger.ONE;
        BigInteger bigInteger2 = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            bigInteger1 = bigInteger1.multiply(new BigInteger(String.valueOf(n - i)));
            bigInteger2 = bigInteger2.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        BigInteger result = bigInteger1.divide(bigInteger2);

        System.out.println(result);
    }
}
