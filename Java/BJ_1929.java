import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 구하기
 */
public class BJ_1929 {
    static boolean[] decimals;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        decimals = new boolean[n+1];
        decimals[0] = decimals[1] = true;
        calculate(n); //소수를 n까지 구하고

        //m부터 n까지 반복문을 통해 소수만 출력한다.
        for (int i = m; i <= n; i++) {
            if(!decimals[i]) System.out.println(i);
        }
    }

    private static void calculate(int n) {
        //에라토스테네스의 체
        //2부터 n까지 2는 제외하고 2로 나눠지는 수들을 다 제거하고,
        //그다음 3은 제외하고 3으로 나눠지는 수들을 다 제거하고
        //n으로 나눠지는 수들까지 다 제거하면 남아있는 수들이 소수이다.
        for (int i = 2; (i*i) < decimals.length; i++) {
            if(!decimals[i]) {
                for (int j = (i*i); j < decimals.length; j += i) {
                    if(!decimals[j]) decimals[j] = true;
                }
            }
        }
    }
}
