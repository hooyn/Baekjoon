import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 종이의 개수
 */
public class BJ_1780 {
    static int n;
    static int[][] arr;
    static int[] result = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0, 0, n);

        for (int val : result) {
            System.out.println(val);
        }
    }

    private static void find(int row, int col, int size) {
        if(check(row, col, size)){
            if(arr[row][col]==-1) result[0]++;
            else if(arr[row][col]==0) result[1]++;
            else if(arr[row][col]==1) result[2]++;

            return;
        } else {
            int newSize = size / 3;

            find(row, col, newSize);
            find(row, col+newSize, newSize);
            find(row, col + 2 * newSize, newSize);

            find(row + newSize, col, newSize);
            find(row + newSize, col + newSize, newSize);
            find(row + newSize, col + 2 * newSize, newSize);

            find(row + 2 * newSize, col, newSize);
            find(row + 2 * newSize, col + newSize, newSize);
            find(row + 2 * newSize, col + 2 * newSize, newSize);
        }

    }

    private static boolean check(int row, int col, int size) {
        int color = arr[row][col];

        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if(color != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
