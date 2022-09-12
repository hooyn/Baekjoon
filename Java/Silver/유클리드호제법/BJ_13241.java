import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최소공배수
 */
public class BJ_13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long result = process(n, m);
        System.out.println(result * (n/result) * (m/result));
    }

    public static long process(long a, long b){
        long temp, n;

        if(b > a) {
            temp = a;
            a = b;
            b = temp;
        }

        while(b != 0){
            n = a % b;
            a = b;
            b = n;
        }

        return a;
    }
}
