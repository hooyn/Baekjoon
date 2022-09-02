import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 숫자의 합
 */
public class BJ_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int number = input.charAt(i)-'0';
            sum += number;
        }

        System.out.println(sum);
    }
}
