import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 4
 */
public class BJ_2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int FIX_N = N;
        StringBuilder sb = new StringBuilder();

        while(true){
            for (int i = 0; i < FIX_N-N; i++) {
                sb.append(" ");
            }
            for (int i = FIX_N-N; i < FIX_N; i++) {
                sb.append("*");
            }
            sb.append("\n");

            N--;
            if(N==0) break;
        }

        System.out.println(sb);
    }
}
