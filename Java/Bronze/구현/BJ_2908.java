import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 상수 브론즈 2
 */
public class BJ_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        String M = st.nextToken();

        N = new StringBuffer(N).reverse().toString();
        M = new StringBuffer(M).reverse().toString();

        int n = Integer.parseInt(N);
        int m = Integer.parseInt(M);

        System.out.println(Math.max(n, m));
    }
}
