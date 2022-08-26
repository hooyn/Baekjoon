import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문자열 반복
 */
public class BJ_2675 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String inputStr = st.nextToken();

            String out = "";
            for (int j = 0; j < inputStr.length(); j++) {

                for (int k = 0; k < count; k++) {

                    out += inputStr.charAt(j);
                }
            }

            System.out.println(out);
        }
    }
}
