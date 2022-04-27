import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 5
 */
public class BJ_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            long sum = 0L;
            st = new StringTokenizer(br.readLine());

            int col1 = Integer.parseInt(st.nextToken());
            int row1 = Integer.parseInt(st.nextToken());

            int col2 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());

            for (int j = col1; j <= col2; j++) {
                for (int k = row1; k <= row2; k++) {
                    int num = arr[j][k];
                    sum += num;
                }
            }

            System.out.println(sum);
        }
    }
}
