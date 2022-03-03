import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 함수
 */
public class BJ_1003 {
    static int zero;
    static int one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            zero = 0;
            one = 0;

            fibonacci(n);
            System.out.println(zero + " " + one);
        }

    }

    public static int fibonacci(int n){
        if (n == 0) {
            zero++;
            return 0;
        } else if (n == 1) {
            one++;
            return 1;
        } else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
}
