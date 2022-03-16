import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * GCD 합
 * 최대공약수에 대해서 유클리드는
 * a와 b의 최대공약수는
 * 'b'를 'a를 b로 나눈 나머지'의 최대공약수와 같다. 라고 했다.
 *
 * 어떤 수와 0의 최대공약수는 자기 자신이라는 성질을 갖는다.
 * gcd(n, 0) = n이라는 말이다.
 *
 * +추가적으로+
 * 최소공배수는 [두 자연수의 곱 / 최대공약수] 이다.
 */
public class BJ_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int z = 0; z < testcase; z++) {
            long result = 0; //-> 합은 long을 쓰도록 하자.
            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            int[] arr = new int[count];

            for (int i = 0; i < count; i++) { //값 배열에 저장
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < count; i++) {
                for (int j = i; j < count; j++) {
                    if(i!=j){
                        result += gcd(arr[i], arr[j]);
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static int gcd(int i1, int i2) {
        if(i2==0) return i1;
        return gcd(i2, i1%i2);
    }
}
