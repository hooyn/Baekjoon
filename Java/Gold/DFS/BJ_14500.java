import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 테트로미노
 */
public class BJ_14500 {
    static int n;
    static int m;
    static int[][] arr;
    static int max = 0;
    static boolean[][] visited;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = pi(st.nextToken());
        m = pi(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = pi(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, arr[i][j], 1); //dfs를 통해서 'ㅏ' 'ㅓ' 'ㅗ' 'ㅜ' 를 제외한 모든 도형을 구현 가능하다.
                rest(i, j); //'ㅏ' 'ㅓ' 'ㅗ' 'ㅜ'에 해당하는 도형에 대해서 score값을 구해준다.
            }
        }

        System.out.println(max);
    }

    private static void dfs(int row, int col, int score, int depth) {
        if(depth>=4){
            max = Math.max(max, score);
            return;
        }

        visited[row][col] = true;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc]){ //범위 내에 있고 방문하지 않은 칸이라면 dfs() 호출
                dfs(nr, nc, score + arr[nr][nc], depth+1);
            }
        }

        visited[row][col] = false;
    }

    private static void rest(int row, int col) { //'ㅏ' 'ㅓ' 'ㅗ' 'ㅜ'에 해당하는 도형의 값을 직접 구해줘서 Math.max()

        if(row+2<n && col+1<m){
            int score = arr[row][col] + arr[row+1][col] + arr[row+2][col] + arr[row+1][col+1];
            max = Math.max(max, score);
        }

        if(row+2<n && col-1>=0){
            int score = arr[row][col] + arr[row+1][col] + arr[row+2][col] + arr[row+1][col-1];
            max = Math.max(max, score);
        }

        if(row+1<n && col+2<m){
            int score = arr[row][col] + arr[row][col+1] + arr[row][col+2] + arr[row+1][col+1];
            max = Math.max(max, score);
        }

        if(row-1>=0 && col+2<m){
            int score = arr[row][col] + arr[row][col+1] + arr[row-1][col+1] + arr[row][col+2];
            max = Math.max(max, score);
        }
    }
}
