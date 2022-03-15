import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2차원 배열의 합
 */
public class BJ_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] list = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int ii = Integer.parseInt(st.nextToken())-1;
            int jj = Integer.parseInt(st.nextToken())-1;
            int xx = Integer.parseInt(st.nextToken())-1;
            int yy = Integer.parseInt(st.nextToken())-1;

            int sum = 0;
            for (int j = ii; j <= xx; j++) {
                for (int k = jj; k <= yy; k++) {
                    sum += list[j][k];
                }
            }
            System.out.println(sum);
        }
    }
}
