import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Z
 */
public class BJ_1074 {
    static int n;
    static int[][] arr;
    static int st_row;
    static int st_col;
    static int result = 0;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        st_row = Integer.parseInt(st.nextToken());
        st_col = Integer.parseInt(st.nextToken());

        find(0, 0, (int) Math.pow(2, n));
        System.out.println(result);
    }

    private static void find(int row, int col, int num) {
        if(row == st_row && col == st_col){
            System.out.println(result);
            System.exit(0);
        }

        if (row <= st_row && st_row < (row+num) && col <= st_col && st_col < (col+num)) {
            int new_n = num/2;

            //4분할로 나눠서 탐색
            find(row, col, new_n);
            find(row, col+new_n, new_n);
            find(row+new_n, col, new_n);
            find(row+new_n, col+new_n, new_n);
        } else {
            result += num * num;
        }
    }
}
