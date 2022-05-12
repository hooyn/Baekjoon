import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 음식물 피하기
 */
public class BJ_1743 {
    static int n;
    static int m;
    static int co;
    static int[][] arr;
    static int count = 1;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        co = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];

        for(int i = 0; i < co; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[r][c] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(arr[i][j] == 1){
                    count = 0;
                    find(i, j);
                    max = Math.max(count, max);
                }
            }
        }

        System.out.println(max);
    }

    private static void find(int row, int col) {
        count++;
        arr[row][col] = 2;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
             int nr = row+dr[i];
             int nc = col+dc[i];

             if((nr>0)&&(nc>0)&&(nr<=n)&&(nc<=m)&&(arr[nr][nc]==1)){
                 find(nr, nc);
             }
        }
    }
}
