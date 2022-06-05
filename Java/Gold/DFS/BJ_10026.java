import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 적록색약
 */
public class BJ_10026 {
    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = pi(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int normal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    find(i, j);
                    normal++;
                }
            }
        }

        int abnormal = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    find_ab(i, j);
                    abnormal++;
                }
            }
        }

        System.out.println(normal + " " + abnormal);
    }

    private static void find_ab(int r, int c) {
        visited[r][c] = true;
        char x = arr[r][c];

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<n){
                if(x =='R' || x=='G'){
                    if((arr[nr][nc] == 'R' || arr[nr][nc] == 'G') && !visited[nr][nc]){
                        find_ab(nr, nc);
                    }
                } else if(arr[nr][nc]==x && !visited[nr][nc]){
                    find_ab(nr, nc);
                }
            }
        }
    }

    private static void find(int r, int c) {
        visited[r][c] = true;
        char x = arr[r][c];

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<n){
                if(arr[nr][nc]==x && !visited[nr][nc]){
                    find(nr, nc);
                }
            }
        }
    }
}
