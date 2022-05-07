import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이 만들기
 */
public class BJ_2630 {
    static int n;
    static int[][] arr;
    static int[] color = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0, 0, n);

        System.out.println(color[0]);
        System.out.println(color[1]);
    }
    public static void find(int row, int col, int len){
        int color_val = arr[row][col];
        boolean check = false;

        if(len==1){
            color[color_val]++;
            return;
        }

        for (int i = row; i < row+len; i++) {
            for (int j = col; j < col+len; j++) {
                if(arr[i][j]!=color_val){
                    check = true;
                    break;
                }
            }
            if(check) break;
        }

        if(check){
            find(row, col, len/2);
            find(row, col+(len/2), len/2);
            find(row+(len/2), col, len/2);
            find(row+(len/2), col+(len/2), len/2);
        } else {
            color[color_val]++;
        }
    }
}
