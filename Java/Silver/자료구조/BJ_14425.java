import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문자열 집합
 * BJ_14425.java
 */

public class BJ_14425 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] set = new String[n];
        for (int i = 0; i < n; i++) {
            set[i] = br.readLine();
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if(set[j].equals(input)){
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
