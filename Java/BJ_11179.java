import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2진수 뒤집기
 */
public class BJ_11179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        String binary_number = Integer.toBinaryString(number);

        StringBuffer sb = new StringBuffer(binary_number);
        sb.reverse();
        //StringBuffer를 이용해서 문자를 역방향으로 돌린다.

        System.out.println(Integer.parseInt(sb.toString(), 2));
        //Integer.parseInt(String s, int radix)
        //숫자형의 문자열을 첫번째 인자 값으로 받고 변환할 진수값을 입력하면 해당 진수에 맞춰
        //Integer 형으로 반환한다.
        //참고: https://jamesdreaming.tistory.com/125
    }
}
