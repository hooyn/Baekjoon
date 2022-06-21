import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기
 */
public class BJ_2206 {
    static int row;
    static int col;
    static int min = 100_000_001;
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new char[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        visited[0][0] = true;
        dfs(0, 0, 1, 0);

        if(min==100_000_001) System.out.println(-1);
        else System.out.println(min);
    }

    private static void dfs(int r, int c, int route, int check) {
        if(r==row-1 && c==col-1){
            min = Math.min(route, min);
            return;
        }

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr>=0 && nr<row && nc>=0 && nc<col && !visited[nr][nc]){
                if(check==0){
                    if(arr[nr][nc] == '0'){
                        visited[nr][nc] = true;
                        dfs(nr, nc, route+1, check);
                        visited[nr][nc] = false;
                    } else {
                        visited[nr][nc] = true;
                        dfs(nr, nc, route+1, 1);
                        visited[nr][nc] = false;
                    }
                } else {
                    if(arr[nr][nc] == '0'){
                        visited[nr][nc] = true;
                        dfs(nr, nc, route+1, check);
                        visited[nr][nc] = false;
                    }
                }
            }
        }
    }
}
