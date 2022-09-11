import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 5 브3
 */
public class BJ_2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = N-1; i >= 0; i--) {

            //공백 출력
            for (int j = i; j > 0; j--) {
                sb.append(" ");
            }

            //별 출력
            for (int j = 0; j < (cnt*2)-1; j++) {
                sb.append("*");
            }
            sb.append("\n");
            cnt++;
        }

        System.out.println(sb);
    }
}
