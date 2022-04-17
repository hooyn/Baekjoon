import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 하노이 탑
 * 메르센 수 2^n-1 => 하노이 탑의 이동 순서
 */
public class BJ_1914 {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bigInteger = new BigInteger("1");
        int n = Integer.parseInt(br.readLine());

        if(n<=20){
            sb.append((int) (Math.pow(2, n) -1)).append('\n'); //하노이 탑 이동 순서 출력
            hanoi(n, 1, 2, 3);
            System.out.println(sb);
        } else {
            for (int i = 0; i < n; i++) {
                bigInteger = bigInteger.multiply(new BigInteger("2"));
            }
            bigInteger = bigInteger.subtract(new BigInteger("1"));
            System.out.println(bigInteger);
        }

    }

    private static void hanoi(int n, int start, int mid, int end) {

        //옮겨야 할 원판의 개수가 1개라면 바로 1->3으로 옮기기
        if(n==1){
            sb.append(start + " " + end + "\n");
            return;
        }

        //A -> B로 N-1개 원판 이동
        hanoi(n-1, start, end, mid);

        //A에 하나 남은 원판 C로 이동 (제일 아래에 깔릴 원판)
        sb.append(start + " " + end + "\n");

        //B -> C로 N-1개 원판 이동
        hanoi(n-1, mid, start, end);
    }
}
