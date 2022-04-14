import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미로 탐색
 */
public class BJ_2178 {
    static int n;
    static int m;
    static char[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        } //미로 배열 초기화

        visited[0][0] = true;
        find(0,0, 1);

        System.out.println(min);
    }

    private static void find(int row, int col, int count) {
        if(row==(n-1)&&col==(m-1)){
            min = Math.min(min, count);
        }

        int[] d_row = {0, 0, 1, -1};
        int[] d_col = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int dd_row = row + d_row[i];
            int dd_col = col + d_col[i];

            if((dd_row>=0&&dd_row<n)&&(dd_col>=0&&dd_col<m)){
                if(arr[dd_row][dd_col]=='1'&&!visited[dd_row][dd_col]){
                    visited[row][col] = true;
                    find(dd_row, dd_col, count+1);
                    visited[row][col] = false; //백트래킹을 위해 false로 해준다.
                }
            }
        }
    }
}
