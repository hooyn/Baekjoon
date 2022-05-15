import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그림
 */
public class BJ_1926 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int size = 0;
    static int max_count = 0;
    static int pi(String s){return Integer.parseInt(s);};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = pi(st.nextToken());
        m = pi(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = pi(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]==1 && !visited[i][j]){
                    int count = find(i, j, 1);
                    max_count = Math.max(max_count, count);
                    size++;
                }
            }
        }

        System.out.println(size);
        System.out.println(max_count);

    }

    private static int find(int row, int col, int count) {
        visited[row][col] = true;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr>=0&&nr<n&&nc>=0&&nc<m){
                if(arr[nr][nc]==1 && !visited[nr][nc]){
                    count += find(nr, nc, 1);
                }
            }
        }

        return count; //몇번을 탐색하는지 반환
    }
}
