import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수
 */
public class BJ_1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long gcd = gcd(n, m); //최대공약수

        StringBuffer sb = new StringBuffer();
        for (long i = 0; i < gcd; i++) { //최대공약수 만큼 1추가
            sb.append("1");
        }

        /**
         * 초기 시도: String 사용
         * -> String str; str+="1";
         * -> 시간 초과
         *
         * 두번째 시도: StringBuffer 사용
         * -> StringBuffer sb; sb.append("1");
         * -> 성공
         * -> 메모리를 String보다 덜 사용한다.
         */

        /**
         * String StringBuffer의 특징
         * 출처: https://go-coding.tistory.com/9
         * String 클래스는 값이 절대 변하지 않기 때문에
         * 문자열을 합칠 때 마다 새로운 주소에 값을 저장한다.
         * 그렇기 때문에 메모리를 StringBuffer보다 더 많이 사용한다.
         *
         * String 클래스는 연산이 적고 문자열을 읽을 일이 많은 경우에 사용하는 것이 적합하다.
         */

        System.out.println(sb.toString());

    }
    static long gcd(long a, long b){
        while(b>0){
            long temp = a;
            a = b;
            b = temp%b;
        }
        return a;
    }
}
