import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 정수 삼각형
 */
public class BJ_1932 {
    static int n;
    static Integer[][] arr;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0,0, 0);

        System.out.println(max);
    }

    private static void find(int row, int col, int count) {
        count += arr[row][col];

        if(row==n-1){
            max = Math.max(max, count);
            return;
        }

        find(row+1, col, count);
        find(row+1, col+1, count);
    }
}
